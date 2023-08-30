package handlers

import (
	"encoding/json"
	"fmt"
	"net/http"
	"os"
	brokerAdapter "passwordRecovery/internal/adapters/broker"
	persistenceAdapter "passwordRecovery/internal/adapters/persistence"
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
	persistencePort "passwordRecovery/internal/ports/persistence"
	"passwordRecovery/internal/utils"
	"passwordRecovery/scripts"

	"github.com/confluentinc/confluent-kafka-go/kafka"
	"golang.org/x/crypto/bcrypt"
)

var userRepository persistencePort.UserPort = &persistenceAdapter.UserAdapter{}

func RecoverPassword(w http.ResponseWriter, r *http.Request) {

	fmt.Printf("server: %v", os.Getenv("BOOTSTRAP_SERVERS"))

	email := r.URL.Query().Get("email")

	db := utils.GetDatabaseConnection()
	defer db.Close()

	tx, err := db.Begin()
	defer tx.Rollback()

	// Find user
	user, err := userRepository.FindByEmail(tx, email)
	if err != nil {
		if myError, ok := err.(*errors.NoDataFound); ok {
			http.Error(w, myError.Error(), http.StatusNotFound)
		} else {
			http.Error(w, err.Error(), http.StatusInternalServerError)
		}
		return
	}

	// Create token
	tokenId, err := CreateToken(tx, user.Id)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	// Find token by id
	foundToken, err := tokenRepository.FindTokenById(tx, tokenId)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	// Saving changes
	err = tx.Commit()
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	// create a new producer
	producer, err := getProducer(os.Getenv("BOOTSTRAP_SERVERS"))
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	// email.sender

	// Provide kafka.producer to the emailSenderAdapter
	emailSender := brokerAdapter.EmailSenderAdapter{
		Producer: producer, Topic: os.Getenv("TOPIC")}

	// Link with the token to recover the password
	link := os.Getenv("RECOVERY_LINK") + foundToken.Token

	// construct an userResponseBroker to send via kafka
	userResponseBroker := &model.UserResponseBroker{
		RecipientEmail: email, Message: scripts.PasswordRecoveryEmailBody(email, link, 15),
		Subject: os.Getenv("SUBJECT")}

	emailSender.Send(userResponseBroker)

	utils.WriteResponse(w, http.StatusCreated, "token created", tokenId)
}

// This function changes the password of an user.
// To successfully change the password, this function checks
// the validity of the token and use the current password to authorize the change.
func ChangePassword(w http.ResponseWriter, r *http.Request) {

	newPasswordRequest := &model.NewPasswordRequest{}

	// Decode json
	err := json.NewDecoder(r.Body).Decode(&newPasswordRequest)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}

	// Get connections
	db := utils.GetDatabaseConnection()
	defer db.Close()

	// init transaction
	tx, err := db.Begin()
	defer tx.Rollback()

	// Check validity of the token
	if isValid, err := ValidateToken(tx, newPasswordRequest.Token); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	} else if !isValid {
		http.Error(w, "Token not valid", http.StatusForbidden)
		return
	}

	// Look for the user by token
	foundUser, err := userRepository.FindByToken(tx, newPasswordRequest.Token)
	if err != nil {
		http.Error(w, err.Error(), http.StatusNotFound)
		return
	}

	// Check if the old password matches
	matched := comparePassword(foundUser.Password, newPasswordRequest.OldPassword)
	if !matched {
		http.Error(w, "Old password do not match", http.StatusUnauthorized)
		return
	}

	// Encrypt new password
	newHashedPassword, err := encryptPassword(newPasswordRequest.NewPassword)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	// Change password
	err = userRepository.ChangePassword(tx, foundUser.Id, newHashedPassword)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	// Confirm token to not be able to use it againg
	err = tokenRepository.ConfirmToken(tx, newPasswordRequest.Token)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	// Save changes
	err = tx.Commit()
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

	utils.WriteResponse(w, http.StatusOK, "Password updated", foundUser.Email)
}

func encryptPassword(password string) (string, error) {
	cost := 10

	hashedPassword, err := bcrypt.GenerateFromPassword([]byte(password), cost)
	if err != nil {
		return "", &errors.HashingError{Message: err}
	}
	return string(hashedPassword), nil
}

func comparePassword(p, p2 string) bool {
	err := bcrypt.CompareHashAndPassword(
		[]byte(p),
		[]byte(p2),
	)
	if err != nil {
		return true
	}

	return false
}

func getProducer(bootstrap_servers string) (*kafka.Producer, error) {
	p, err := kafka.NewProducer(&kafka.ConfigMap{
		"bootstrap.servers": os.Getenv("BOOTSTRAP_SERVERS"),
		"client.id":         "1",
		"acks":              "all"})

	if err != nil {
		return nil, err
	}
	return p, nil
}

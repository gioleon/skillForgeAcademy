package handlers

import (
	"encoding/json"
	"net/http"
	"passwordRecovery/internal/adapters"
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
	"passwordRecovery/internal/ports"
	"passwordRecovery/internal/utils"

	"golang.org/x/crypto/bcrypt"
)

var userRepository ports.UserPort = &adapters.UserAdapter{}

func RecoverPassword(w http.ResponseWriter, r *http.Request) {

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

	// Saving changes
	err = tx.Commit()
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}

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
	if err := bcrypt.CompareHashAndPassword(
		[]byte(foundUser.Password),
		[]byte(newPasswordRequest.OldPassword)); err != nil {
		http.Error(w, "Old password do not match", http.StatusUnauthorized)
		return
	}

	// Encrypt new password
	newHashedPassword, err := EncryptPassword(newPasswordRequest.NewPassword)
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

func EncryptPassword(password string) (string, error) {
	cost := 10

	hashedPassword, err := bcrypt.GenerateFromPassword([]byte(password), cost)
	if err != nil {
		return "", &errors.HashingError{Message: err}
	}
	return string(hashedPassword), nil
}

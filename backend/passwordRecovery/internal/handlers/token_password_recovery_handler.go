package handlers

import (
	"encoding/json"
	"net/http"
	"passwordRecovery/internal/adapters"
	"passwordRecovery/internal/model"
	"passwordRecovery/internal/ports"
	"time"

	"github.com/google/uuid"
)

var tokenRepository ports.TokenPasswordRecoveryPort = &adapters.TokenAdapter{}

func Create(w http.ResponseWriter, r *http.Request) {
	// this function in the request body receives the userId
	token := &model.TokenPasswordRecovery{}

	// Set user id
	err := json.NewDecoder(r.Body).Decode(&token)
	if err != nil {
		panic(err)
	}

	// Setting other parameters
	token.ExpiredAt = time.Now().Add(time.Minute * 15)
	token.CreatedAt = time.Now()
	token.Token = uuid.New().String()

	id, err := tokenRepository.Create(token)
	if err != nil {
		panic(err)
	}

	json.NewEncoder(w).Encode(&id)
}

func DeleteById(w http.ResponseWriter, r *http.Request) {
	token := &model.TokenPasswordRecovery{}

	err := json.NewDecoder(r.Body).Decode(&token)
	if err != nil {
		panic(err)
	}

	id, err := tokenRepository.DeleteById(token.Id)
	if err != nil {
		panic(err)
	}

	json.NewEncoder(w).Encode(&id)

}

func ValidateToken(token string) bool {
	// Get the token
	foundToken, err := tokenRepository.FindByToken(token)
	if err != nil {
		panic(err)
	}

	// Parsing the representation of null date time from string to time.Time
	layout := "2006-01-02 00:00:00" // layout specifies the format of the date
	nullDateRepresentation, err := time.Parse(layout, "0001-01-01 00:00:00")
	if err != nil {
		panic(err)
	}

	// Verify if the token has not been confirmed and is still valid
	if foundToken.ConfirmedAt.Equal(nullDateRepresentation) && foundToken.ExpiredAt.After(time.Now()) {
		return true
	}

	return false
}

func ConfirmToken(token string) {
	err := tokenRepository.ConfirmToken(token)
	if err != nil {
		panic(err)
	}
}

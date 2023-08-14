package handlers

import (
	"database/sql"
	"passwordRecovery/internal/adapters"
	"passwordRecovery/internal/model"
	"passwordRecovery/internal/ports"
	"time"

	"github.com/google/uuid"
)

var tokenRepository ports.TokenPasswordRecoveryPort = &adapters.TokenAdapter{}

func CreateToken(tx *sql.Tx, userId int) (int, error) {
	// this function in the request body receives the userId
	token := &model.TokenPasswordRecovery{}

	// Setting other parameters
	token.ExpiredAt = time.Now().Add(time.Minute * 15)
	token.CreatedAt = time.Now()
	token.Token = uuid.New().String()
	token.UserId = userId

	id, err := tokenRepository.CreateToken(tx, token)

	return id, err
}

func DeleteTokenById(tx *sql.Tx, id int) {
	id, err := tokenRepository.DeleteTokenById(tx, id)
	if err != nil {
		panic(err)
	}
}

func ValidateToken(tx *sql.Tx, token string) bool {
	// Get the token
	foundToken, err := tokenRepository.FindTokenByToken(tx, token)
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

func ConfirmToken(tx *sql.Tx, token string) {
	err := tokenRepository.ConfirmToken(tx, token)
	if err != nil {
		panic(err)
	}
}

package handlers

import (
	"database/sql"
	"passwordRecovery/internal/adapters"
	"passwordRecovery/internal/errors"
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

func DeleteTokenById(tx *sql.Tx, id int) error {
	id, err := tokenRepository.DeleteTokenById(tx, id)
	if err != nil {
		return &errors.DeleteError{Message: err}
	}
	return nil
}

func ValidateToken(tx *sql.Tx, token string) (bool, error) {
	// Get the token
	foundToken, err := tokenRepository.FindTokenByToken(tx, token)
	if err != nil {
		return false, &errors.NoDataFound{Message: err}
	}

	// Verify if the token has not been confirmed and is still valid
	if foundToken.ConfirmedAt.IsZero() && foundToken.ExpiredAt.After(time.Now().Local()) {
		return true, nil
	}

	return false, nil
}

func ConfirmToken(tx *sql.Tx, token string) error {
	err := tokenRepository.ConfirmToken(tx, token)
	if err != nil {
		return &errors.ConfirmTokenError{Message: err}
	}

	return nil
}

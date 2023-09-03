package handlers

import (
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
	ports "passwordRecovery/internal/ports/persistence"
	"time"

	"github.com/google/uuid"
)

type TokenHandler struct {
	TokenRepository ports.TokenPasswordRecoveryPort
}

func (tokenHandler *TokenHandler) CreateToken(userId int) (int, error) {
	// this function in the request body receives the userId
	token := &model.TokenPasswordRecovery{}

	// Setting other parameters
	token.ExpiredAt = time.Now().Add(time.Minute * 15)
	token.CreatedAt = time.Now()
	token.Token = uuid.New().String()
	token.UserId = userId

	id, err := tokenHandler.TokenRepository.CreateToken(token)

	return id, err
}

func (tokenHandler *TokenHandler) DeleteTokenById(id int) error {
	id, err := tokenHandler.TokenRepository.DeleteTokenById(id)
	if err != nil {
		return &errors.DeleteError{Message: err}
	}
	return nil
}

func (tokenHandler *TokenHandler) ValidateToken(token string) (bool, error) {
	// Get the token
	foundToken, err := tokenHandler.TokenRepository.FindTokenByToken(token)
	if err != nil {
		return false, &errors.NoDataFound{Message: err}
	}

	// Verify if the token has not been confirmed and is still valid
	if foundToken.ConfirmedAt.IsZero() && foundToken.ExpiredAt.After(time.Now().Local()) {
		return true, nil
	}

	return false, nil
}

func (tokenHandler *TokenHandler) ConfirmToken(token string) error {
	err := tokenHandler.TokenRepository.ConfirmToken(token)
	if err != nil {
		return &errors.ConfirmTokenError{Message: err}
	}

	return nil
}

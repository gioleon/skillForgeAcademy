package persistence

import (
	"passwordRecovery/internal/model"
)

type TokenPasswordRecoveryPort interface {
	CreateToken(token *model.TokenPasswordRecovery) (int, error)
	DeleteTokenById(tokenId int) (int, error)
	FindTokenById(tokenId int) (*model.TokenPasswordRecovery, error)
	FindTokenByToken(token string) (*model.TokenPasswordRecovery, error)
	ConfirmToken(token string) error
}

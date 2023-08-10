package ports

import (
	"passwordRecovery/internal/model"
)

type TokenPasswordRecoveryPort interface {
	Persistence[model.TokenPasswordRecovery]
	FindByToken(token string) (*model.TokenPasswordRecovery, error)
	ConfirmToken(token string) error
}

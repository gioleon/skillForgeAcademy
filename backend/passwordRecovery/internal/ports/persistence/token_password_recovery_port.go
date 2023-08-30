package persistence

import (
	"database/sql"
	"passwordRecovery/internal/model"
)

type TokenPasswordRecoveryPort interface {
	CreateToken(tx *sql.Tx, token *model.TokenPasswordRecovery) (int, error)
	DeleteTokenById(tx *sql.Tx, tokenId int) (int, error)
	FindTokenById(tx *sql.Tx, tokenId int) (*model.TokenPasswordRecovery, error)
	FindTokenByToken(tx *sql.Tx, token string) (*model.TokenPasswordRecovery, error)
	ConfirmToken(tx *sql.Tx, token string) error
}

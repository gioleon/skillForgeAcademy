package ports

import (
	"database/sql"
	"passwordRecovery/internal/model"
)

type UserPort interface {
	FindByEmail(tx *sql.Tx, email string) (*model.User, error)
	ChangePassword(tx *sql.Tx, id int, newPassword string) error
}

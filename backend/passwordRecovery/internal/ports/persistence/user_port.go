package persistence

import (
	"passwordRecovery/internal/model"
)

type UserPort interface {
	FindByEmail(email string) (*model.User, error)
	ChangePassword(id int, newPassword string) error
	FindByToken(token string) (*model.User, error)
}

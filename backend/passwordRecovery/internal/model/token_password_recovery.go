package model

import (
	"time"
)

type TokenPasswordRecovery struct {
	Id          int
	Token       string
	CreatedAt   time.Time
	ExpiredAt   time.Time
	ConfirmedAt time.Time
	UserId      int
}

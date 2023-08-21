package model

type NewPasswordRequest struct {
	Token       string `json:"token"`
	NewPassword string `json:"newPassword"`
	OldPassword string `json:"oldPassword"`
}

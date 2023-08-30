package model

type UserResponseBroker struct {
	RecipientEmail string `json:"recipientEmail"`
	Message        string `json:"message"`
	Subject        string `json:"subject"`
}

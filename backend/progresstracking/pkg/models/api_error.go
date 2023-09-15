package models

type ApiError struct {
	Code    int `json:"code"`
	Message any `json:"message"`
}

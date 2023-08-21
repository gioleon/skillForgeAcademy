package utils

import (
	"encoding/json"
	"net/http"
	"passwordRecovery/internal/model"
)

func WriteResponse(w http.ResponseWriter, statusCode int, message string, result any) {
	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(statusCode)

	response := &model.ApiResponse{
		StatusCode: statusCode,
		Message:    message,
		Result:     result,
	}

	json.NewEncoder(w).Encode(response)
}

func WriteSuccessResponse(w http.ResponseWriter, statusCode int, message string) {
	WriteResponse(w, statusCode, message, nil)
}

func WriteErrorResponse(w http.ResponseWriter, statusCode int, message string) {
	WriteResponse(w, statusCode, message, nil)
}

package handlers

import (
	"encoding/json"
	"log"
	"net/http"
	"passwordRecovery/internal/adapters"
	"passwordRecovery/internal/errors"
	"passwordRecovery/internal/model"
	"passwordRecovery/internal/ports"
	"passwordRecovery/internal/utils"
)

var userRepository ports.UserPort = &adapters.UserAdapter{}

func RecoverPassword(w http.ResponseWriter, r *http.Request) {

	email := r.URL.Query().Get("email")

	db := utils.GetDatabaseConnection()
	defer db.Close()

	tx, err := db.Begin()
	defer tx.Rollback()

	// Find user
	user, err := userRepository.FindByEmail(tx, email)
	if err != nil {
		if myError, ok := err.(*errors.NoDataFound); ok {
			writeResponse(w, http.StatusOK, myError.Message.Error(), user)
		} else {
			http.Error(w, err.Error(), http.StatusBadRequest)
		}
		return
	}

	// Create token
	tokenId, err := CreateToken(tx, user.Id)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
	}

	// Saving changes
	err = tx.Commit()
	if err != nil {
		log.Fatal(err)
		return
	}

	writeResponse(w, http.StatusOK, "token created", tokenId)
}

func writeResponse(w http.ResponseWriter, statusCode int, message string, result any) {

	w.Header().Set("Content-Type", "application/json")
	w.WriteHeader(statusCode)

	response := &model.ApiResponse{
		StatusCode: statusCode,
		Message:    message,
		Result:     result,
	}

	json.NewEncoder(w).Encode(response)
}

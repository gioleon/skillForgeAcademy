package handlers

import (
	"encoding/json"
	"net/http"
	"passwordRecovery/internal/interfaces"
	"passwordRecovery/internal/model"
	"passwordRecovery/internal/repository"
	"time"

	"github.com/google/uuid"
)

var tokenRepository interfaces.Persistence[model.TokenPasswordRecovery] = &repository.TokenRepository{}

func Create(w http.ResponseWriter, r *http.Request) {
	// this function in the request body receives the userId
	token := &model.TokenPasswordRecovery{}

	// Set user id
	err := json.NewDecoder(r.Body).Decode(&token)
	if err != nil {
		panic(err)
	}

	// Setting other parameters
	token.ExpiredAt = time.Now().Add(time.Minute * 15)
	token.CreatedAt = time.Now()
	token.Token = uuid.New().String()

	id, err := tokenRepository.Create(token)
	if err != nil {
		panic(err)
	}

	json.NewEncoder(w).Encode(&id)
}

func DeleteById(w http.ResponseWriter, r *http.Request) {
	token := &model.TokenPasswordRecovery{}

	err := json.NewDecoder(r.Body).Decode(&token)
	if err != nil {
		panic(err)
	}

	id, err := tokenRepository.DeleteById(token.Id)
	if err != nil {
		panic(err)
	}

	json.NewEncoder(w).Encode(&id)

}

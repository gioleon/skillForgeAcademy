package server

import (
	"net/http"
	"passwordRecovery/internal/handlers"
)

func InitRoutes() http.Handler {

	userHandler := &handlers.UserHandler{}

	mux := http.NewServeMux()

	mux.HandleFunc("/recoverPassword", func(w http.ResponseWriter, r *http.Request) {
		switch r.Method {
		case http.MethodGet:
			userHandler.RecoverPassword(w, r)
		}
	})

	mux.HandleFunc("/changePassword", func(w http.ResponseWriter, r *http.Request) {
		if r.Method == http.MethodPost {
			userHandler.ChangePassword(w, r)
		} else {
			http.Error(w, "Only post method allowed", http.StatusBadRequest)
		}

	})

	return mux
}

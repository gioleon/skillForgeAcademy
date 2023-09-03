package server

import (
	"net/http"
	"passwordRecovery/internal/handlers"
)

func InitRoutes() {

	userHandler := &handlers.UserHandler{}

	http.HandleFunc("/recoverPassword", func(w http.ResponseWriter, r *http.Request) {
		switch r.Method {
		case http.MethodGet:
			userHandler.RecoverPassword(w, r)
		}
	})

	http.HandleFunc("/changePassword", func(w http.ResponseWriter, r *http.Request) {
		if r.Method == http.MethodPost {
			userHandler.ChangePassword(w, r)
		} else {
			http.Error(w, "Also post method allowed", http.StatusBadRequest)
		}

	})
}

package server

import (
	"net/http"
	"passwordRecovery/internal/handlers"
)

func InitRoutes() {
	http.HandleFunc("/recoverPassword", func(w http.ResponseWriter, r *http.Request) {
		switch r.Method {
		case http.MethodGet:
			handlers.RecoverPassword(w, r)
		}
	})

	http.HandleFunc("/changePassword", func(w http.ResponseWriter, r *http.Request) {
		if r.Method == http.MethodPost {
			handlers.ChangePassword(w, r)
		} else {
			http.Error(w, "Also post method allowed", http.StatusBadRequest)
		}

	})
}

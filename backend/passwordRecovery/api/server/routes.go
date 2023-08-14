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
}

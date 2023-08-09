package server

import (
	"net/http"
	"passwordRecovery/internal/handlers"
)

func InitRoutes() {
	http.HandleFunc("/token", func(w http.ResponseWriter, r *http.Request) {
		switch r.Method {
		case http.MethodPost:
			handlers.Create(w, r)
		case http.MethodDelete:
			handlers.DeleteById(w, r)
		}

	})
}

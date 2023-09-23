package main

import (
	"passwordRecovery/api/server"
	"passwordRecovery/config"
	"passwordRecovery/scripts"

	"github.com/rs/cors"
)

func main() {
	// Load env vars
	config.LoadEnv()

	// Create table if not exists
	scripts.CreateTable()

	// Get server
	srv := server.New("8088")

	cors := cors.New(cors.Options{
		AllowedOrigins: []string{"*"},
		AllowedMethods: []string{"GET", "POST", "PUT", "DELETE"},
		AllowedHeaders: []string{"Content-Type", "Authorization"},
	})

	srv.Handler = cors.Handler(server.InitRoutes())

	err := srv.ListenAndServe()
	if err != nil {
		panic(err)
	}
}

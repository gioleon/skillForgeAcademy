package main

import (
	"passwordRecovery/api/server"
	"passwordRecovery/config"
	"passwordRecovery/scripts"
)

func main() {
	// Load env vars
	config.LoadEnv()

	// Create table if not exists
	scripts.CreateTable()

	// init routes
	server.InitRoutes()

	// Get server
	srv := server.New("8080")

	err := srv.ListenAndServe()
	if err != nil {
		panic(err)
	}

}

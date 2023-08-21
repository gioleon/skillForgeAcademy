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

	// db := utils.GetDatabaseConnection()
	// defer db.Close()

	// tx, err := db.Begin()
	// defer tx.Rollback()

	// if err != nil {
	// 	return
	// }

	// fmt.Println(handlers.ValidateToken(tx, "13775afa-efcf-449d-b869-2f3081c1296e"))

	// Get server
	srv := server.New("8088")

	err := srv.ListenAndServe()
	if err != nil {
		panic(err)
	}

}

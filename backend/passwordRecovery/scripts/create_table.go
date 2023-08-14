package scripts

import (
	"fmt"
	"os"
	"passwordRecovery/pkg"

	_ "github.com/lib/pq"
)

func CreateTable() {
	databaseName := "skillforgeacademy"

	// Get database connection
	db := pkg.SetDatabaseConnection(
		os.Getenv("DB_HOST"), os.Getenv("DB_PORT"),
		os.Getenv("DB_USER"), os.Getenv("DB_PASSWORD"),
		databaseName)

	defer db.Close()

	_, tableCheck := db.Query("SELECT * FROM tokens_password_recovery LIMIT 1")

	if tableCheck != nil {
		query, err := os.ReadFile("scripts/tokens_password_recovery.sql")
		if err != nil {
			panic(err)
		}

		_, err = db.Exec(string(query))
		if err != nil {
			panic(err)
		}
		fmt.Printf("Table tokens password recovery created")
	} else {
		fmt.Println("Table tokens password recovery already exists")
	}
}

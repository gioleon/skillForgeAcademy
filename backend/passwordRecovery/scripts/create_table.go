package scripts

import (
	"log"
	"os"
	"passwordRecovery/internal/utils"
)

func CreateTable() {

	// Get database connection
	db := utils.GetConnectionPool()

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
		log.Printf("Table tokens password recovery created")
	} else {
		log.Println("Table tokens password recovery already exists")
	}
}

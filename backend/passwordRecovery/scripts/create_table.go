package scripts

import (
	"context"
	"fmt"
	"log"
	"os"
	"passwordRecovery/internal/utils"
)

func CreateTable() {

	// Get database connection
	db := utils.GetConnectionPool(context.Background())

	conn, err := db.Acquire(context.Background())
	if err != nil {
		log.Fatal(err)
	}
	defer conn.Release()

	_, tableCheck := conn.Query(context.Background(), "SELECT * FROM tokens_password_recovery LIMIT 1")

	if tableCheck != nil {
		query, err := os.ReadFile("scripts/tokens_password_recovery.sql")
		if err != nil {
			panic(err)
		}

		_, err = conn.Exec(context.Background(), string(query))
		if err != nil {
			panic(err)
		}
		fmt.Printf("Table tokens password recovery created")
	} else {
		fmt.Println("Table tokens password recovery already exists")
	}
}

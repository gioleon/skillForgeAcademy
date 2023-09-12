package scripts

import (
	"context"
	"log"
	"os"

	"github.com/gioleon/progresstracking/internal/database"
)

func CreateTable(ctx context.Context) {

	// Get database connection
	db := database.GetConnectionPool()

	_, tableCheck := db.QueryContext(ctx, "SELECT * FROM progress_tracking LIMIT 1")

	if tableCheck != nil {
		query, err := os.ReadFile("internal/progresstracking/scripts/progress_tracking.sql")
		if err != nil {
			panic(err)
		}

		_, err = db.Exec(string(query))
		if err != nil {
			panic(err)
		}
		log.Printf("Table progress tracking created")
	} else {
		log.Println("Table progress tracking already exists")
	}
}

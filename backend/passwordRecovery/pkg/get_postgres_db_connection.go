package pkg

import (
	"database/sql"
	"fmt"

	_ "github.com/lib/pq"
)

func SetDatabaseConnection(host, port, user, password, dbName string) *sql.DB {
	psqlInfo := fmt.Sprintf("host=%s port=%s user=%s "+
		"password=%s dbname=%s sslmode=disable",
		host, port, user, password, dbName)
	db, err := sql.Open("postgres", psqlInfo)
	if err != nil {
		panic(err)
	}

	return db
}

package utils

import (
	"database/sql"
	"os"
	"passwordRecovery/pkg"
	"sync"
)

var (
	db     *sql.DB
	dbOnce sync.Once
)

func GetDatabaseConnection() *sql.DB {
	dbOnce.Do(func() {
		databaseName := "skillforgeacademy"

		db = pkg.SetDatabaseConnection(
			os.Getenv("DB_HOST"), os.Getenv("DB_PORT"),
			os.Getenv("DB_USER"), os.Getenv("DB_PASSWORD"),
			databaseName)
	})

	return db
}

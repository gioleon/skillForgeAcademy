package utils

import (
	"database/sql"
	"os"
	"passwordRecovery/pkg"
)

func GetDatabaseConnection() *sql.DB {
	databaseName := "skillforgeacademy"

	return pkg.SetDatabaseConnection(
		os.Getenv("DB_HOST"), os.Getenv("DB_PORT"),
		os.Getenv("DB_USER"), os.Getenv("DB_PASSWORD"),
		databaseName)
}

package utils

import (
	"context"
	"fmt"
	"os"
	"sync"

	"github.com/jackc/pgx/v4/pgxpool"
)

var (
	dbPool     *pgxpool.Pool
	dbPoolOnce sync.Once
)

func GetConnectionPool(ctx context.Context) *pgxpool.Pool {
	dbPoolOnce.Do(func() {
		host := os.Getenv("DB_HOST")
		port := os.Getenv("DB_PORT")
		user := os.Getenv("DB_USER")
		password := os.Getenv("DB_PASSWORD")
		databaseName := "skillforgeacademy"

		connString := fmt.Sprintf("host=%s port=%s user=%s password=%s dbname=%s sslmode=disable",
			host, port, user, password, databaseName)
		var err error
		dbPool, err = pgxpool.Connect(ctx, connString)
		if err != nil {
			panic(err)
		}
	})

	return dbPool
}

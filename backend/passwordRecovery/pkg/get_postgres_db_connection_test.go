package pkg

import (
	"database/sql"
	"testing"

	_ "github.com/lib/pq"
)

type test struct {
	name     string
	host     string
	port     string
	user     string
	password string
	dbName   string
	want     error
}

func TestSetDatabaseConnection(t *testing.T) {
	tests := []test{
		{
			name:     "Valid database connection",
			host:     "localhost",
			port:     "5432",
			user:     "postgres",
			password: "password",
			dbName:   "testdb",
			want:     nil,
		},
		{
			name:     "Invalid host",
			host:     "invalidhost",
			port:     "5432",
			user:     "postgres",
			password: "password",
			dbName:   "testdb",
			want:     sql.ErrConnDone,
		},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			db := SetDatabaseConnection(tc.host, tc.port, tc.user, tc.password, tc.dbName)
			if db == nil && tc.want != nil {
				t.Errorf("Failed to set database connection")
			}
		})
	}
}

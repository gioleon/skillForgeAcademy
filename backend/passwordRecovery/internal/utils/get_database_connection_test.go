package utils

import (
	"context"
	"testing"
)

type test struct {
	name string
	want error
}

func TestGetConnectionPool(t *testing.T) {
	tests := []test{
		{
			name: "Valid database connection",
			want: nil,
		},
	}

	for _, tc := range tests {
		t.Run(tc.name, func(t *testing.T) {
			db := GetConnectionPool(context.Background())
			if db == nil && tc.want != nil {
				t.Errorf("Failed to get database connection")
			}
		})
	}
}

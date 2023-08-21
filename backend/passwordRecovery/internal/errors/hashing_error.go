package errors

import "fmt"

type HashingError struct {
	Message error
}

func (err *HashingError) Error() string {
	return fmt.Sprintf("%v", err.Message)
}

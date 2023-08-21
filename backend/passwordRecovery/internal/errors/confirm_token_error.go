package errors

import "fmt"

type ConfirmTokenError struct {
	Message error
}

func (e *ConfirmTokenError) Error() string {
	return fmt.Sprintf("%v", e.Message)
}

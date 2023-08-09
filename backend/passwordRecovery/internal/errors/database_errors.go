package errors

import "fmt"

type NoDataFound struct {
	Message error
}

func (err *NoDataFound) Error() string {
	return fmt.Sprintf("%v", err.Message)
}

type InsertionError struct {
	Message error
}

func (err *InsertionError) Error() string {
	return fmt.Sprintf("%v", err.Message)
}

type DeleteError struct {
	Message error
}

func (err *DeleteError) Error() string {
	return fmt.Sprintf("%v", err.Message)
}

type ScanError struct {
	Message error
}

func (err *ScanError) Error() string {
	return fmt.Sprintf("%v", err.Message)
}

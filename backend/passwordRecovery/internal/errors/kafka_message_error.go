package errors

import "fmt"

type KafkaMessageError struct {
	Message string
}

func (err *KafkaMessageError) Error() string {
	return fmt.Sprintf("%v", err.Message)
}

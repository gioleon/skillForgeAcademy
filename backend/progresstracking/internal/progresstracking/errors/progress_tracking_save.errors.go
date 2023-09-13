package errors

type DomainError struct {
	Message string
}

func (e *DomainError) Error() string {
	return e.Message
}

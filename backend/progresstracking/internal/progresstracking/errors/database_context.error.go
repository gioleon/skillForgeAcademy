package errors

type DatabaseTimeOutError struct {
}

func (e *DatabaseTimeOutError) Error() string {
	return "Database operation passed the deadline"
}

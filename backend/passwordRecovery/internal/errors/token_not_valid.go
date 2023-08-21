package errors

type TokenNotValid struct {
	Message string
}

func (t *TokenNotValid) Error() string {
	return "TOKEN NOT VALID"
}

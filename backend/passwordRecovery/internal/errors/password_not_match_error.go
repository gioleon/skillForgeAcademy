package errors

import "fmt"

type PasswordNotMatchError struct {
	Message string
}

func (p *PasswordNotMatchError) Error() string {
	return fmt.Sprintf("%v", p.Message)
}

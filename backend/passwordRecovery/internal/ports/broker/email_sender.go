package broker

type EmailSenderPort[T any] interface {
	Send(t *T) error
}

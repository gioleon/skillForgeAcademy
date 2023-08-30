package persistence

type Persistence[T any] interface {
	Create(element *T) (int, error)
	DeleteById(elementId int) (int, error)
	FindById(elementId int) (*T, error)
}

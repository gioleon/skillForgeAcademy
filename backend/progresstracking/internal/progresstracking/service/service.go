package service

import (
	"context"

	"github.com/gioleon/progresstracking/pkg/models"
)

type Service interface {
	SaveUserProgress(ctx context.Context, progress *models.ProgressTracking) error
	GetUserProgress(ctx context.Context, userId int, courseId int) ([]*models.ProgressTracking, error)
}

package repository

import (
	"context"

	"github.com/gioleon/progresstracking/pkg/models"
)

type Repository interface {
	SaveProgress(ctx context.Context, progress *models.ProgressTracking) error
	GetUserProgress(ctx context.Context, userId int, courseId int) ([]*models.ProgressTracking, error)
	GetProgress(ctx context.Context, progress *models.ProgressTracking) (bool, error)
}

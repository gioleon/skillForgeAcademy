package service

import (
	"context"
	"log"

	"github.com/gioleon/progresstracking/internal/progresstracking/errors"
	"github.com/gioleon/progresstracking/internal/progresstracking/repository"
	"github.com/gioleon/progresstracking/pkg/models"
)

type ProgressTrackingService struct {
	Repository repository.Repository
}

func (s *ProgressTrackingService) SaveUserProgress(ctx context.Context, progress *models.ProgressTracking) error {

	// Validate progress
	err := s.ValidateProgress(ctx, progress)
	if err != nil {
		log.Print(err)
		return err
	}

	alreadyExists, err := s.Repository.GetProgress(ctx, progress)
	if err != nil {
		log.Print(err)
		return err
	}

	if !alreadyExists {
		err := s.SaveProgress(ctx, progress)
		if err != nil {
			log.Print(err)
			return err
		}
	}

	return nil
}

func (s *ProgressTrackingService) GetUserProgress(ctx context.Context, userId, courseId int) ([]*models.ProgressTracking, error) {
	userProgress, err := s.Repository.GetUserProgress(ctx, userId, courseId)
	if err != nil {
		log.Print(err)
		return nil, err
	}

	return userProgress, nil
}

func (s *ProgressTrackingService) ValidateProgress(ctx context.Context, progress *models.ProgressTracking) error {
	if progress.UserId <= 0 {
		return &errors.DomainError{Message: "userId can not be empty"}
	}

	if progress.CourseId <= 0 {
		return &errors.DomainError{Message: "courseId can not be empty"}
	}

	if progress.ClassId <= 0 {
		return &errors.DomainError{Message: "classId can not be empty"}
	}

	return nil
}

func (s *ProgressTrackingService) SaveProgress(ctx context.Context, progress *models.ProgressTracking) error {
	err := s.Repository.SaveProgress(ctx, progress)
	if err != nil {
		log.Fatal(err)
		return err
	}
	return nil
}

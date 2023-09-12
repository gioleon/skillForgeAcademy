package service

import (
	"context"
	"testing"
	"time"

	"github.com/gioleon/progresstracking/internal/progresstracking/errors"
	"github.com/gioleon/progresstracking/pkg/models"
	"github.com/stretchr/testify/assert"
)

type Test struct {
}

func TestValidateProgress(t *testing.T) {
	testCases := []struct {
		Name      string
		UserId    int
		CourseId  int
		ClassId   int
		StartedAt time.Time
		Expected  error
	}{
		{
			Name:     "Validate progress",
			UserId:   1,
			CourseId: 1,
			ClassId:  1,
			Expected: nil,
		},
		{
			Name:     "UserId can not be empty",
			UserId:   0,
			CourseId: 1,
			ClassId:  1,
			Expected: &errors.DomainError{Message: "userId can not be empty"},
		},
		{
			Name:     "CourseId can not be empty",
			UserId:   1,
			CourseId: 0,
			ClassId:  1,
			Expected: &errors.DomainError{Message: "courseId can not be empty"},
		},
		{
			Name:     "ClassId can not be empty",
			UserId:   1,
			CourseId: 1,
			ClassId:  0,
			Expected: &errors.DomainError{Message: "classId can not be empty"},
		},
	}

	for _, tc := range testCases {
		t.Run(tc.Name, func(t *testing.T) {
			progressTrackingService := &ProgressTrackingService{Repository: nil}

			progress := &models.ProgressTracking{
				UserId:   tc.UserId,
				CourseId: tc.CourseId,
				ClassId:  tc.ClassId,
			}

			err := progressTrackingService.ValidateProgress(context.Background(), progress)
			if tc.Expected == nil {
				assert.IsType(t, err, tc.Expected)
			} else {
				assert.EqualError(t, err, tc.Expected.Error())
			}
		})
	}
}

func TestGetUserProgress(t *testing.T) {

}

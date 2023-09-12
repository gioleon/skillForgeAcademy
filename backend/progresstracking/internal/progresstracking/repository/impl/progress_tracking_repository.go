package repository

import (
	"context"
	"database/sql"

	"github.com/gioleon/progresstracking/pkg/models"
)

type ProgressTrackingRepository struct {
	DB *sql.DB
}

func (r *ProgressTrackingRepository) SaveProgress(ctx context.Context, progress *models.ProgressTracking) error {

	sqlInsertStatement := `
	    INSERT INTO progress_tracking (user_id, course_id, class_id)
	    VALUES  ($1, $2, $3)
	`

	_, err := r.DB.ExecContext(
		ctx, sqlInsertStatement,
		progress.UserId, progress.CourseId,
		progress.ClassId,
	)

	if err != nil {
		return err
	}

	return nil
}

func (r *ProgressTrackingRepository) GetUserProgress(
	ctx context.Context, userId int,
	courseId int) ([]*models.ProgressTracking, error) {

	// Prepare query
	sqlStatement := `
	    SELECT user_id, course_id, class_id FROM progress_tracking
		WHERE user_id = $1
		AND course_id = $2
	`

	// Get rows
	rows, err := r.DB.QueryContext(ctx, sqlStatement, userId, courseId)
	if err != nil {
		return nil, err
	}
	defer rows.Close()

	userProgress := []*models.ProgressTracking{}

	// Loop rows
	for rows.Next() {
		progress := &models.ProgressTracking{}

		err := rows.Scan(&progress.UserId, &progress.CourseId, &progress.ClassId)
		if err != nil {
			return nil, err
		}

		userProgress = append(userProgress, progress)
	}

	return userProgress, nil
}

func (r *ProgressTrackingRepository) GetProgress(ctx context.Context, progress *models.ProgressTracking) (bool, error) {

	foundProgress := &models.ProgressTracking{}

	sqlStatement := `
	    SELECT user_id, course_id, class_id FROM progress_tracking
		WHERE user_id = $1
		AND course_id = $2
		AND class_id = $3
	`
	row := r.DB.QueryRowContext(
		ctx, sqlStatement, progress.UserId,
		progress.CourseId, progress.ClassId,
	)

	switch err := row.Scan(&foundProgress.UserId, &foundProgress.CourseId, &foundProgress.ClassId); err {
	case sql.ErrNoRows:
		return false, nil
	case nil:
		return true, nil
	default:
		return true, err
	}
}

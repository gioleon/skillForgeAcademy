package rest

import (
	"context"
	"log"
	"net/http"
	"strconv"
	"time"

	"github.com/gin-gonic/gin"
	"github.com/gioleon/progresstracking/internal/database"
	"github.com/gioleon/progresstracking/internal/progresstracking/errors"
	repository "github.com/gioleon/progresstracking/internal/progresstracking/repository/impl"
	service "github.com/gioleon/progresstracking/internal/progresstracking/service/impl"
	"github.com/gioleon/progresstracking/pkg/models"
)

func SaveUserProgress(c *gin.Context) {

	ctx, cancel := context.WithTimeout(context.Background(), time.Second*10)
	defer cancel()

	db := database.GetConnectionPool()

	repository := &repository.ProgressTrackingRepository{DB: db}
	service := service.ProgressTrackingService{Repository: repository}

	progress := &models.ProgressTracking{}

	if err := c.BindJSON(&progress); err != nil {
		c.IndentedJSON(
			http.StatusInternalServerError,
			&models.ApiError{Code: http.StatusInternalServerError, Message: err.Error()},
		)
		return
	}

	if err := service.SaveUserProgress(ctx, progress); err != nil {
		if err, ok := err.(*errors.DomainError); ok {
			c.IndentedJSON(http.StatusBadRequest,
				&models.ApiError{Code: http.StatusBadRequest, Message: err.Error()},
			)
			return
		}
		c.IndentedJSON(http.StatusInternalServerError,
			&models.ApiError{Code: http.StatusInternalServerError, Message: err.Error()},
		)
		return
	}

	c.IndentedJSON(http.StatusCreated, "OK")
}

func GetUserProgress(c *gin.Context) {
	ctx, cancel := context.WithTimeout(context.Background(), time.Second*2)
	defer cancel()

	db := database.GetConnectionPool()

	repository := &repository.ProgressTrackingRepository{DB: db}
	service := service.ProgressTrackingService{Repository: repository}

	userId, err := strconv.ParseInt(c.Query("userId"), 8, 64)
	if err != nil {
		c.IndentedJSON(http.StatusInternalServerError,
			&models.ApiError{Code: http.StatusInternalServerError, Message: err.Error()},
		)
		return
	}

	courseId, err := strconv.ParseInt(c.Query("courseId"), 8, 64)
	if err != nil {
		c.IndentedJSON(http.StatusInternalServerError,
			&models.ApiError{Code: http.StatusInternalServerError, Message: err.Error()},
		)
		return
	}

	progress, err := service.GetUserProgress(ctx, int(userId), int(courseId))
	if err != nil {
		log.Print(err)
		c.IndentedJSON(http.StatusInternalServerError,
			&models.ApiError{Code: http.StatusInternalServerError, Message: err.Error()},
		)
		return
	}

	c.IndentedJSON(http.StatusOK,
		&models.ApiError{Code: http.StatusOK, Message: progress},
	)
}

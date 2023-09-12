package rest

import (
	"context"
	"log"
	"net/http"
	"strconv"

	"github.com/gin-gonic/gin"
	"github.com/gioleon/progresstracking/internal/database"
	"github.com/gioleon/progresstracking/internal/progresstracking/errors"
	repository "github.com/gioleon/progresstracking/internal/progresstracking/repository/impl"
	service "github.com/gioleon/progresstracking/internal/progresstracking/service/impl"
	"github.com/gioleon/progresstracking/pkg/models"
)

func SaveUserProgress(ctx context.Context, c *gin.Context) {

	db := database.GetConnectionPool()

	repository := &repository.ProgressTrackingRepository{DB: db}
	service := service.ProgressTrackingService{Repository: repository}

	progress := &models.ProgressTracking{}

	if err := c.BindJSON(&progress); err != nil {
		c.AbortWithError(http.StatusInternalServerError, err)
	}

	if err := service.SaveUserProgress(ctx, progress); err != nil {
		switch err {
		case &errors.DomainError{}:
			c.AbortWithError(http.StatusBadGateway, err)
		default:
			c.AbortWithError(http.StatusInternalServerError, err)
		}
	}

	c.IndentedJSON(http.StatusCreated, "OK")

}

func GetUserProgress(ctx context.Context, c *gin.Context) {
	db := database.GetConnectionPool()

	repository := &repository.ProgressTrackingRepository{DB: db}
	service := service.ProgressTrackingService{Repository: repository}

	userId, err := strconv.ParseInt(c.Query("userId"), 8, 64)
	if err != nil {
		c.AbortWithStatus(http.StatusInternalServerError)
	}

	courseId, err := strconv.ParseInt(c.Query("courseId"), 8, 64)
	if err != nil {
		c.AbortWithStatus(http.StatusInternalServerError)
	}
	progress, err := service.GetUserProgress(ctx, int(userId), int(courseId))
	if err != nil {
		log.Print(err)
		c.AbortWithStatus(http.StatusInternalServerError)
	}

	c.IndentedJSON(http.StatusOK, progress)
}

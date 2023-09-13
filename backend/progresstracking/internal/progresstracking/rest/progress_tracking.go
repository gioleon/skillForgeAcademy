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

func GetUserProgress(c *gin.Context) {
	ctx, cancel := context.WithTimeout(context.Background(), time.Second*2)
	defer cancel()

	db := database.GetConnectionPool()

	repository := &repository.ProgressTrackingRepository{DB: db}
	service := service.ProgressTrackingService{Repository: repository}

	userId, err := strconv.ParseInt(c.Query("userId"), 8, 64)
	if err != nil {
		c.AbortWithError(http.StatusInternalServerError, err)
	}

	courseId, err := strconv.ParseInt(c.Query("courseId"), 8, 64)
	if err != nil {
		c.AbortWithError(http.StatusInternalServerError, err)
	}

	progress, err := service.GetUserProgress(ctx, int(userId), int(courseId))
	if err != nil {
		log.Print(err)
		c.AbortWithError(http.StatusInternalServerError, err)
	}

	c.IndentedJSON(http.StatusOK, progress)
}

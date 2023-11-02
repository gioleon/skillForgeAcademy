package main

import (
	"context"

	"github.com/gin-gonic/gin"
	"github.com/gioleon/progresstracking/config"
	"github.com/gioleon/progresstracking/internal/progresstracking/rest"
	"github.com/gioleon/progresstracking/internal/progresstracking/scripts"
)

func main() {
	config.LoadEnv()

	ctx := context.Background()

	// Create table
	scripts.CreateTable(ctx)

	routes := gin.Default()

	routes.POST("/api/progress", rest.SaveUserProgress)
	routes.GET("/api/progress", rest.GetUserProgress)

	routes.Run(":8089")
}

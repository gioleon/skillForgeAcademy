package main

import (
	"context"

	"github.com/gin-gonic/gin"
	"github.com/gioleon/progresstracking/config"
	"github.com/gioleon/progresstracking/internal/progresstracking/rest"
	"github.com/gioleon/progresstracking/internal/progresstracking/scripts"
)

// @title           Swagger Example API
// @version         1.0
// @description     This is a sample server celler server.
// @termsOfService  http://swagger.io/terms/

// @contact.name   API Support
// @contact.url    http://www.swagger.io/support
// @contact.email  support@swagger.io

// @license.name  Apache 2.0
// @license.url   http://www.apache.org/licenses/LICENSE-2.0.html

// @host      localhost:8080
// @BasePath  /api/v1

// @securityDefinitions.basic  BasicAuth

// @externalDocs.description  OpenAPI
// @externalDocs.url          https://swagger.io/resources/open-api/
func main() {
	// Load env vars
	config.LoadEnv()

	// ctx, cancel := context.WithTimeout(context.Background(), time.Second*10)
	// defer cancel()

	ctx := context.Background()

	// Create table
	scripts.CreateTable(ctx)

	routes := gin.Default()

	routes.POST("/api/progress", func(c *gin.Context) {
		rest.SaveUserProgress(ctx, c)
	})

	routes.GET("/api/progress", func(c *gin.Context) {
		rest.GetUserProgress(ctx, c)
	})

	routes.Run(":8088")
}

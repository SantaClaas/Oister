package main

import (
	"fmt"
	"github.com/labstack/echo/v4"
	"gitlab.projectoc.de/pgamemaster/pgamemaster/internal/config"
	"gitlab.projectoc.de/pgamemaster/pgamemaster/internal/controllers"
	"gitlab.projectoc.de/pgamemaster/pgamemaster/internal/models"
	"gitlab.projectoc.de/pgamemaster/pgamemaster/internal/routes"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
	"log"
	"net/http"
)

var (
	AuthController      controllers.AuthController
	AuthRouteController routes.AuthRouteController
	UserController      controllers.UserController
	UserRouteController routes.UserRouteController
	db                  *gorm.DB
)

func loadConfiguration() config.Config {
	conf, err := config.LoadConfig(".")
	if err != nil {
		log.Fatal("? Could not load environment variables", err)
	}
	return conf
}

func init() {
	config := loadConfiguration()

	dsn := fmt.Sprintf("host=%s user=%s password=%s dbname=%s port=%s sslmode=disable TimeZone=Europe/Berlin",
		config.DBHost,
		config.DBUserName,
		config.DBUserPassword,
		config.DBName,
		config.DBPort)

	db, _ = gorm.Open(postgres.Open(dsn), &gorm.Config{})

	if db.Migrator().HasTable(&models.User{}) {
		_ = db.AutoMigrate(&models.User{})
	}
}

func main() {
	conf := loadConfiguration()
	server := echo.New()
	router := server.Group("/api")
	router.GET("/health", func(ctx echo.Context) error {
		m := map[string]interface{}{
			"status": "success",
		}
		return ctx.JSON(http.StatusOK, m)
	})

	server.Logger.Fatal(server.Start(":" + conf.ServerPort))
}

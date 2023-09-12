package models

type ProgressTracking struct {
	UserId   int `json:"userId"`
	CourseId int `json:"courseId"`
	ClassId  int `json:"classId"`
}

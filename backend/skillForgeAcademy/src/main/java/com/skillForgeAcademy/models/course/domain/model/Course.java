package com.skillForgeAcademy.models.course.domain.model;

import com.skillForgeAcademy.models.category.domain.model.Category;
import com.skillForgeAcademy.models.user.domain.model.User;

import java.time.LocalDate;

public class Course {

    private long id;
    private String name;
    private String description;

    private Category[] categories;

    // private Comment[] comments;

    // private Grade[] grades;

    private User teacher;

    private User[] students;

    private LocalDate createdAt;

    private LocalDate modifiedAt;
}

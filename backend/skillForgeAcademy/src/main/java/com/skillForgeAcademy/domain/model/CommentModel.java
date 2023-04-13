package com.skillForgeAcademy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {
    private long id;
    private CourseModel course;
    private UserModel user;
}
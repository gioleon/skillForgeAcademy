package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import java.util.List;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.model.DescriptionModel;
import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.model.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id
    private long id;
    private List<RateModel> rate;
    private List<CategoryModel> category;
    private UserModel owner;
    private UserModel student;
    private String name;
    private List<DescriptionModel> description;

}

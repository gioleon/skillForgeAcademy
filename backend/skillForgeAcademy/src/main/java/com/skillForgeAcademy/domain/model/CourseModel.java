package com.skillForgeAcademy.domain.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {
    private long id;
    private List<RateModel> rate;
    private List<CategoryModel> category;
    private UserModel owner;
    private UserModel student;
    private String name;
    private List<DescriptionModel> description;


}

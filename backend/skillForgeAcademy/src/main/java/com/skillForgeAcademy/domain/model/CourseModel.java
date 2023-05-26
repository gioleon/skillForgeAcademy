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
    private List<CategoryModel> category;
    private String name;
    private UserModel owner;
    private String description;
    private String urlImage;


}

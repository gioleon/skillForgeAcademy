package com.skillForgeAcademy.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean isEnable;
    private Collection<RolModel> roles;

    private UniversityModel university;

    public UserModel(
            String name, String lastName,
            String email, String password,
            UniversityModel university) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnable = false;
        this.university = university;
    }
}

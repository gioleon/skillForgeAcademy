package com.skillForgeAcademy.domain.model;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean isEnable;
    private Collection<RolModel> roles;

    public UserModel(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnable = false;
    }
}

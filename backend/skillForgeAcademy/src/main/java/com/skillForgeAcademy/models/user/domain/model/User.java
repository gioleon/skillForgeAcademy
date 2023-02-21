package com.skillForgeAcademy.models.user.domain.model;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.user.infrastructure.database.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean isEnable;
    private Collection<Rol> roles;

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnable = false;
    }

    public UserEntity toUserEntity() {
        return UserEntity.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .email(this.email)
                .password(this.password)
                .isEnable(this.isEnable)
                .roles(this.roles.stream().map(rol -> rol.toRolEntity()).collect(Collectors.toList()))
                .build();
    }


}

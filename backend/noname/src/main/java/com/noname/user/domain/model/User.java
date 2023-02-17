package com.noname.user.domain.model;

import com.noname.rol.domain.model.Rol;
import com.noname.user.infrastructure.database.entity.UserEntity;
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
    private Collection<Rol> roles;

    public UserEntity toUserEntity() {
        return UserEntity.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .email(this.email)
                .password(this.password)
                .roles(this.roles.stream().map(rol -> rol.toRolEntity()).collect(Collectors.toList()))
                .build();
    }
}

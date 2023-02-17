package com.noname.user.infrastructure.database.entity;

import com.noname.rol.domain.model.Rol;
import com.noname.rol.infrastructure.entity.RolEntity;
import com.noname.user.domain.model.User;
import jakarta.persistence.*;
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
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RolEntity> roles;

    public User toUser() {
        return User.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .email(this.email)
                .password(this.password)
                .roles(this.roles.stream().map(rolEntity -> rolEntity.toRol()).collect(Collectors.toList()))
                .build();
    }
}

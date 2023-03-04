package com.skillForgeAcademy.models.user.infrastructure.postgresAdapter.entity;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.entity.RolEntity;
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
    private boolean isEnable;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RolEntity> roles;

    public User toUser() {
        return User.builder()
                .id(this.id)
                .name(this.name)
                .lastName(this.lastName)
                .email(this.email)
                .password(this.password)
                .isEnable(this.isEnable)
                .roles(this.roles.stream().map(rolEntity -> rolEntity.toRol()).collect(Collectors.toList()))
                .build();
    }
}

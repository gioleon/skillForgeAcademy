package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
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

    public UserModel toUser() {
        return UserModel.builder()
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

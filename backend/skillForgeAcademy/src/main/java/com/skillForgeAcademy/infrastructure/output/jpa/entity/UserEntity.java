package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
import jakarta.persistence.*;
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
@AllArgsConstructor
@NoArgsConstructor
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

}

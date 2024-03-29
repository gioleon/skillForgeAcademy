package com.skillForgeAcademy.infrastructure.output.jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean isEnable;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RolEntity> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    private UniversityEntity university;
}

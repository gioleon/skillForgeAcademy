package com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.entity;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    public RolEntity(String name) {
        this.name = name;
    }

    public Rol toRol(){
        return Rol.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}

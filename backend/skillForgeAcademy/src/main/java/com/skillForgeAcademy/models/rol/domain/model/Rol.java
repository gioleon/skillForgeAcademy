package com.skillForgeAcademy.models.rol.domain.model;

import com.skillForgeAcademy.models.rol.infrastructure.entity.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol {
    private int id;
    private String name;

    public Rol(String name) {
        this.name = name;
    }

    public RolEntity toRolEntity() {
        return RolEntity.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }

}

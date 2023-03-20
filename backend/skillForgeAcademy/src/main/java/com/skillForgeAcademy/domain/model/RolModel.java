package com.skillForgeAcademy.domain.model;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolModel {
    private int id;
    private String name;

    public RolModel(String name) {
        this.name = name;
    }

    public RolEntity toRolEntity() {
        return RolEntity.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }

}

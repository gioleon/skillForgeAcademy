package com.skillForgeAcademy.domain.model;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolModel {
    private int id;
    private String name;
}

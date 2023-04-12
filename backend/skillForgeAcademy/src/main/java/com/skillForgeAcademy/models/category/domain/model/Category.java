package com.skillForgeAcademy.models.category.domain.model;

import com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private int id;
    private String name;

    public Category(String name){
        this.name = name;
    }

    public CategoryEntity toCategoryEntity(){
        return  CategoryEntity.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}

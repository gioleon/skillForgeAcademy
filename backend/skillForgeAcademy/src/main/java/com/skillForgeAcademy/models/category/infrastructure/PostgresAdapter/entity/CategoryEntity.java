package com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.entity;

import com.skillForgeAcademy.models.category.domain.model.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public CategoryEntity(String name){
        this.name = name;
    }

    public Category toCategory(){
        return Category.builder()
                .id(this.getId())
                .name(this.getName())
                .build();

    }
}

package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.domain.spi.persistence.ICategoryPersistencePort;

import java.util.List;

public class CategoryJpaAdapter implements ICategoryPersistencePort {
    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        return null;
    }

    @Override
    public CategoryModel find(Long id) {
        return null;
    }

    @Override
    public List<CategoryModel> findAll() {
        return null;
    }

    @Override
    public CategoryModel delete(Long id) {
        return null;
    }
}

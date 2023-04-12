package com.skillForgeAcademy.models.category.domain.service;

import com.skillForgeAcademy.models.category.domain.model.Category;
import com.skillForgeAcademy.models.category.domain.ports.input.CategoryServicePort;
import com.skillForgeAcademy.models.category.domain.ports.output.CategoryPersistencePort;

public class CategoryServiceImpl implements CategoryServicePort {

    private CategoryPersistencePort categoryPersistencePort;

    public CategoryServiceImpl(CategoryPersistencePort categoryPersistencePort){
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public Category find(Integer id) {
        return null;
    }

    @Override
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public Category delete(Integer id) throws Exception {
        return null;
    }
}

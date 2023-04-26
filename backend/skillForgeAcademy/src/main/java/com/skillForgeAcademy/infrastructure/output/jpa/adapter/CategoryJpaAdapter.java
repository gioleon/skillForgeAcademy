package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import java.util.List;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.domain.spi.persistence.ICategoryPersistencePort;

public class CategoryJpaAdapter implements ICategoryPersistencePort {

    

    @Override
    public CategoryModel create(CategoryModel t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CategoryModel find(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public List<CategoryModel> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public CategoryModel delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}

package com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.adapter;

import com.skillForgeAcademy.models.category.domain.model.Category;
import com.skillForgeAcademy.models.category.domain.ports.output.CategoryPersistencePort;
import com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.entity.CategoryEntity;
import com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.repository.PostgresCategoryEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
public class CategoryPostgresAdapter implements CategoryPersistencePort {


    @Autowired
    private PostgresCategoryEntityRepository repository;

    @Override
    public Category create(Category category) {
        return this.repository.save(category.toCategoryEntity()).toCategory();
    }

    @Override
    public Category find(Integer id) {
        Optional<CategoryEntity> category =  this.repository.findById(id);
        return !category.isEmpty() ? category.get().toCategory() : null;
    }

    @Override
    public Iterable<Category> findAll() {
        return ((List<CategoryEntity>) this.repository.findAll())
                .stream()
                .map(CategoryEntity::toCategory)
                .collect(Collectors.toList());
    }

    @Override
    public Category delete(Integer id) throws Exception {

        Category foundCategory = this.find(id);

        if(foundCategory == null){
            log.warn("USER NOT FOUND: {}", id);
            throw new Exception("USER NOT EXISTS");
        }

        this.repository.deleteById(id);

        return foundCategory;
    }
}

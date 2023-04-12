package com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.repository;

import com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostgresCategoryEntityRepository extends CrudRepository<CategoryEntity, Integer> {
}

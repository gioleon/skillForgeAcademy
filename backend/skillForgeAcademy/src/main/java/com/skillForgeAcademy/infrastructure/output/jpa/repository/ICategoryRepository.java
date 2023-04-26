package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CategoryEntity;

public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long>{


}

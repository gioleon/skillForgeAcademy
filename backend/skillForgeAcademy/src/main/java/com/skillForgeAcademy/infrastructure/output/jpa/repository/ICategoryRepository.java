package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long>{


}

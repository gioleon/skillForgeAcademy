package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.domain.spi.persistence.ICategoryPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CategoryEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICategoryEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICategoryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

  private final ICategoryRepository categoryRepository;
  private final ICategoryEntityMapper categoryEntityMapper;

  @Override
  public CategoryModel create(CategoryModel t) {
    CategoryEntity category = categoryRepository.save(
      categoryEntityMapper.toEntity(t)
    );

    return categoryEntityMapper.toModel(category);
  }

  @Override
  public CategoryModel find(Long id) {
    Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);

    if (categoryEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    return categoryEntityMapper.toModel(categoryEntity.get());
  }

  @Override
  public List<CategoryModel> findAll() {
    return categoryEntityMapper.toCategoryModelList(
      (List<CategoryEntity>) categoryRepository.findAll()
    );
  }

  @Override
  public CategoryModel delete(Long id) {
    Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
    if (categoryEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    categoryRepository.deleteById(id);
    return categoryEntityMapper.toModel(categoryEntity.get());
  }
}

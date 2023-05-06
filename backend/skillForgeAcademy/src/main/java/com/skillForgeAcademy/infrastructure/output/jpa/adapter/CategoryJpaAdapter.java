package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.domain.spi.persistence.ICategoryPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICategoryEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

  private final ICategoryRepository categoryRepository;
  private final ICategoryEntityMapper categoryEntityMapper;

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

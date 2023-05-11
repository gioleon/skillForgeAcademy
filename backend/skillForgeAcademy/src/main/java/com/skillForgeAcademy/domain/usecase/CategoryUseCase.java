package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ICategoryServicePort;
import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.domain.spi.persistence.ICategoryPersistencePort;
import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

  private ICategoryPersistencePort categoryPersistencePort;

  public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
    this.categoryPersistencePort = categoryPersistencePort;
  }

  @Override
  public CategoryModel create(CategoryModel categoryModel) {
    return categoryPersistencePort.create(categoryModel);
  }

  @Override
  public CategoryModel find(Long id) {
    return categoryPersistencePort.find(id);
  }

  @Override
  public List<CategoryModel> findAll() {
    return categoryPersistencePort.findAll();
  }

  @Override
  public CategoryModel delete(Long id) {
    return categoryPersistencePort.delete(id);
  }
}

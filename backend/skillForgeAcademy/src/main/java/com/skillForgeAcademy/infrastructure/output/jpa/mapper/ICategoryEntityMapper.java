package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CategoryEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ICategoryEntityMapper {
  CategoryModel toModel(CategoryEntity categoryEntity);
  CategoryEntity toEntity(CategoryModel categoryModel);
  List<CategoryModel> toCategoryModelList(
    List<CategoryEntity> categoryEntityList
  );
}

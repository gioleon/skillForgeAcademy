package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.CategoryModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {
    CategoryModel toModel(CategoryModel categoryModel);
    CategoryEntity toEntity(CategoryModel categoryModel);
    List<CategoryModel> toModelList(List<CategoryEntity> categoryEntities);
}

package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.CategoryRequestDto;
import com.skillForgeAcademy.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryRequestMapper {
  CategoryModel toModel(CategoryRequestDto categoryRequestDto);
}

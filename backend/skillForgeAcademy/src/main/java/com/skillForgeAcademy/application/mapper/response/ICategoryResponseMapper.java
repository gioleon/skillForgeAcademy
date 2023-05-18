package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.CategoryResponseDto;
import com.skillForgeAcademy.domain.model.CategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;import java.util.List;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryResponseMapper {
  CategoryResponseDto toResponse(CategoryModel categoryModel);
  List<CategoryResponseDto> toResponseList(List<CategoryModel> category);
}

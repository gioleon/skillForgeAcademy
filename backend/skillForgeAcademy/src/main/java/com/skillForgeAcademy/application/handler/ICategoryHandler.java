package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.CategoryRequestDto;
import com.skillForgeAcademy.application.dto.response.CategoryResponseDto;
import java.util.List;

public interface ICategoryHandler {

  void create(CategoryRequestDto categoryRequestDto);

  CategoryResponseDto find(Long id);

  List<CategoryResponseDto> getAllCategories();

  CategoryResponseDto delete(Long id);
}

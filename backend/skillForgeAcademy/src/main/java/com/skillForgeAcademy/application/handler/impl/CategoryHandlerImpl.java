package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.CategoryRequestDto;
import com.skillForgeAcademy.application.dto.response.CategoryResponseDto;
import com.skillForgeAcademy.application.handler.ICategoryHandler;
import com.skillForgeAcademy.application.mapper.request.ICategoryRequestMapper;
import com.skillForgeAcademy.application.mapper.response.ICategoryResponseMapper;
import com.skillForgeAcademy.domain.api.ICategoryServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CategoryHandlerImpl implements ICategoryHandler {

  private final ICategoryServicePort categoryServicePort;
  private final ICategoryResponseMapper categoryResponseMapper;
  private final ICategoryRequestMapper categoryRequestMapper;

  @Override
  public void create(CategoryRequestDto categoryRequestDto) {
    categoryServicePort.create(categoryRequestMapper.toModel(categoryRequestDto));
  }

  @Override
  public CategoryResponseDto find(Long id) {
    return categoryResponseMapper.toResponse(categoryServicePort.find(id));
  }

  @Override
  public List<CategoryResponseDto> getAllCategories() {
    return categoryResponseMapper.toResponseList(categoryServicePort.findAll());
  }

  @Override
  public CategoryResponseDto delete(Long id) {
    return categoryResponseMapper.toResponse(categoryServicePort.delete(id));
  }
}

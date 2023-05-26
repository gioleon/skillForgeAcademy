package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.response.CourseResponseDto;
import com.skillForgeAcademy.application.handler.ICourseHandler;
import com.skillForgeAcademy.application.mapper.request.ICourseRequestMapper;
import com.skillForgeAcademy.application.mapper.response.ICourseResponseMapper;
import com.skillForgeAcademy.domain.api.ICourseServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CourseHandlerImpl implements ICourseHandler {
  private final ICourseServicePort courseServicePort;
  private final ICourseRequestMapper courseRequestMapper;
  private final ICourseResponseMapper courseResponseMapper;

  @Override
  public void create(CourseRequestDto courseRequestDto) {
    courseServicePort.create(courseRequestMapper.toModel(courseRequestDto));
  }

  @Override
  public CourseResponseDto find(Long id) {
    return courseResponseMapper.toResponse(courseServicePort.find(id));
  }

  @Override
  public CourseResponseDto delete(Long id) {
    return courseResponseMapper.toResponse(courseServicePort.delete(id));
  }

  @Override
  public List<CourseResponseDto> getAllCourses() {
    return courseResponseMapper.toResponseList(courseServicePort.findAll());
  }

  @Override
  public List<CourseResponseDto> findByOwner(Long idOwner) {
    return courseResponseMapper.toResponseList(courseServicePort.findByOwner(idOwner));
  }
}

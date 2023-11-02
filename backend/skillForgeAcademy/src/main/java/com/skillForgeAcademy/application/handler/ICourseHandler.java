package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.response.CourseResponseDto;
import java.util.List;

public interface ICourseHandler {
  void create(CourseRequestDto courseRequestDto);

  CourseResponseDto find(Long id);

  CourseResponseDto delete(Long id);

  List<CourseResponseDto> getAllCourses();

  List<CourseResponseDto> findByOwner(Long id);

  List<CourseResponseDto> findByName(String name);
}

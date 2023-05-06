package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.spi.persistence.ICoursePersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICourseEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICourseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseJpaAdapter implements ICoursePersistencePort {

  private final ICourseRepository courseRepository;
  private final ICourseEntityMapper courseEntityMapper;

  @Override
  public CourseModel create(CourseModel courseModel) {
    return null;
  }

  @Override
  public CourseModel find(Long id) {
    return null;
  }

  @Override
  public List<CourseModel> findAll() {
    return null;
  }

  @Override
  public CourseModel delete(Long id) {
    return null;
  }
}

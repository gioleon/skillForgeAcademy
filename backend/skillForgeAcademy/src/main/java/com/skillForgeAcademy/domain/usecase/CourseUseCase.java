package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ICourseServicePort;
import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.spi.persistence.ICoursePersistencePort;
import java.util.List;

public class CourseUseCase implements ICourseServicePort {

  private ICoursePersistencePort coursePersistencePort;

  public CourseUseCase(ICoursePersistencePort coursePersistencePort) {
    this.coursePersistencePort = coursePersistencePort;
  }

  @Override
  public CourseModel create(CourseModel courseModel) {
    return coursePersistencePort.create(courseModel);
  }

  @Override
  public CourseModel find(Long id) {
    return coursePersistencePort.find(id);
  }

  @Override
  public List<CourseModel> findAll() {
    return coursePersistencePort.findAll();
  }

  @Override
  public CourseModel delete(Long id) {
    return coursePersistencePort.delete(id);
  }
}

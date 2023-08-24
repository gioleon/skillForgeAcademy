package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ICourseServicePort;
import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.spi.persistence.ICoursePersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IUserPersistencePort;
import java.util.List;

public class CourseUseCase implements ICourseServicePort {

  private ICoursePersistencePort coursePersistencePort;
  private IUserPersistencePort userPersistencePort;

  public CourseUseCase(
      ICoursePersistencePort coursePersistencePort, IUserPersistencePort userPersistencePort) {
    this.coursePersistencePort = coursePersistencePort;
    this.userPersistencePort = userPersistencePort;
  }

  @Override
  public CourseModel create(CourseModel courseModel) {
    UserModel userModel = userPersistencePort.find(courseModel.getOwner().getId());
    courseModel.setOwner(userModel);
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

  @Override
  public List<CourseModel> findByOwner(Long idOwner) {
    UserModel owner = new UserModel();
    owner.setId(idOwner);
    return coursePersistencePort.findByOwner(owner);
  }
}

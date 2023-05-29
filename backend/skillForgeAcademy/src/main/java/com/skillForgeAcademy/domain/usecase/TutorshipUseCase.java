package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ITutorshipServicePort;
import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;
import java.util.List;

public class TutorshipUseCase implements ITutorshipServicePort {

  private ITutorshipPersistencePort tutorshipPersistencePort;

  public TutorshipUseCase(ITutorshipPersistencePort persistencePort) {
    this.tutorshipPersistencePort = persistencePort;
  }

  @Override
  public TutorshipModel create(TutorshipModel tutorshipModel) {
    Long id = tutorshipPersistencePort.findLastId();

    tutorshipModel.setId((id != null) ? id + 1 : 1);
    return tutorshipPersistencePort.create(tutorshipModel);
  }

  @Override
  public TutorshipModel find(TutorshipModelId id) {
    return tutorshipPersistencePort.find(id);
  }

  @Override
  public List<TutorshipModel> findAll() {
    return tutorshipPersistencePort.findAll();
  }

  @Override
  public TutorshipModel delete(TutorshipModelId id) {
    return tutorshipPersistencePort.delete(id);
  }

  @Override
  public List<TutorshipModel> findByCourse(Long id) {
    CourseModel courseModel = new CourseModel();
    courseModel.setId(id);
    return tutorshipPersistencePort.findByCourse(courseModel);
  }
}

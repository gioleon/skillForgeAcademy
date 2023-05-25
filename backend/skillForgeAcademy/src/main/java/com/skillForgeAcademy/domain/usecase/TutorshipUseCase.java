package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ITutorshipServicePort;
import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;
import java.util.List;
import java.util.UUID;

public class TutorshipUseCase implements ITutorshipServicePort {

  private ITutorshipPersistencePort tutorshipPersistencePort;

  public TutorshipUseCase(ITutorshipPersistencePort persistencePort) {
    this.tutorshipPersistencePort = persistencePort;
  }

  @Override
  public TutorshipModel create(TutorshipModel tutorshipModel) {
    tutorshipModel.setId(UUID.randomUUID().toString());
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
}

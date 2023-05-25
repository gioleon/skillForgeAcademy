package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ISectionServicePort;
import com.skillForgeAcademy.domain.model.SectionModel;
import com.skillForgeAcademy.domain.model.SectionModelId;
import com.skillForgeAcademy.domain.spi.persistence.ISectionPersistencePort;
import java.util.List;
import java.util.UUID;

public class SectionUseCase implements ISectionServicePort {

  private ISectionPersistencePort sectionPersistencePort;

  public SectionUseCase(ISectionPersistencePort sectionPersistencePort) {
    this.sectionPersistencePort = sectionPersistencePort;
  }

  @Override
  public SectionModel create(SectionModel sectionModel) {
    sectionModel.setId(UUID.randomUUID().toString());
    return sectionPersistencePort.create(sectionModel);
  }

  @Override
  public SectionModel find(SectionModelId id) {
    return sectionPersistencePort.find(id);
  }

  @Override
  public List<SectionModel> findAll() {
    return sectionPersistencePort.findAll();
  }

  @Override
  public SectionModel delete(SectionModelId id) {
    return sectionPersistencePort.delete(id);
  }
}

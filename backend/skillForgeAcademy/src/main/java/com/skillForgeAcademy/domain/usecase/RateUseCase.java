package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IRateServicePort;
import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.model.RateModelId;
import com.skillForgeAcademy.domain.spi.persistence.IRatePersistencePort;
import java.util.List;

public class RateUseCase implements IRateServicePort {

  private IRatePersistencePort ratePersistencePort;

  public RateUseCase(IRatePersistencePort ratePersistencePort) {
    this.ratePersistencePort = ratePersistencePort;
  }

  @Override
  public RateModel create(RateModel rateModel) {
    return ratePersistencePort.create(rateModel);
  }

  @Override
  public List<RateModel> findAll() {
    return ratePersistencePort.findAll();
  }

  @Override
  public RateModel find(RateModelId id) {
    return ratePersistencePort.find(id);
  }

  @Override
  public RateModel delete(RateModelId id) {
    return ratePersistencePort.delete(id);
  }
}

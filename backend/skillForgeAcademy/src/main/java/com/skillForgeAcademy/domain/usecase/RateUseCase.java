package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IRateServicePort;
import com.skillForgeAcademy.domain.model.RateModel;
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
    public RateModel find(Long id) {
        return ratePersistencePort.find(id);
    }

    @Override
    public List<RateModel> findAll() {
        return ratePersistencePort.findAll();
    }

    @Override
    public RateModel delete(Long id) {
        return ratePersistencePort.delete(id);
    }
}

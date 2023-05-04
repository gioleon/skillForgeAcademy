package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.spi.persistence.IRatePersistencePort;

import java.util.List;

public class RateJpaAdapter implements IRatePersistencePort {
    @Override
    public RateModel create(RateModel rateModel) {
        return null;
    }

    @Override
    public RateModel find(Long id) {
        return null;
    }

    @Override
    public List<RateModel> findAll() {
        return null;
    }

    @Override
    public RateModel delete(Long id) {
        return null;
    }
}

package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.spi.persistence.IRatePersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRateEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IRateRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RateJpaAdapter implements IRatePersistencePort {

    private final IRateRepository rateRepository;
    private final IRateEntityMapper rateEntityMapper;

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

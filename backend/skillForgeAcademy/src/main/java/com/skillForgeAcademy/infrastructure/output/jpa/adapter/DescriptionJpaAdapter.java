package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.DescriptionModel;
import com.skillForgeAcademy.domain.spi.persistence.IDescriptionPersistencePort;

import java.util.List;

public class DescriptionJpaAdapter implements IDescriptionPersistencePort {
    @Override
    public DescriptionModel create(DescriptionModel descriptionModel) {
        return null;
    }

    @Override
    public DescriptionModel find(Long id) {
        return null;
    }

    @Override
    public List<DescriptionModel> findAll() {
        return null;
    }

    @Override
    public DescriptionModel delete(Long id) {
        return null;
    }
}

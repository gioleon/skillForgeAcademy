package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IDescriptionServicePort;
import com.skillForgeAcademy.domain.model.DescriptionModel;
import com.skillForgeAcademy.domain.spi.persistence.IDescriptionPersistencePort;

import java.util.List;

public class DescriptionUseCase implements IDescriptionServicePort {
    private IDescriptionPersistencePort descriptionPersistencePort;

    public DescriptionUseCase(IDescriptionPersistencePort descriptionPersistencePort) {
        this.descriptionPersistencePort = descriptionPersistencePort;
    }

    @Override
    public DescriptionModel create(DescriptionModel descriptionModel) {
        return descriptionPersistencePort.create(descriptionModel);
    }

    @Override
    public DescriptionModel find(Long id) {
        return descriptionPersistencePort.find(id);
    }

    @Override
    public List<DescriptionModel> findAll() {
        return descriptionPersistencePort.findAll();
    }

    @Override
    public DescriptionModel delete(Long id) {
        return descriptionPersistencePort.delete(id);
    }
}

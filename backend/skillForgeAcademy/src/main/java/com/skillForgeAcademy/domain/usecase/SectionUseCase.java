package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ISectionServicePort;
import com.skillForgeAcademy.domain.model.SectionModel;
import com.skillForgeAcademy.domain.spi.persistence.ISectionPersistencePort;

import java.util.List;

public class SectionUseCase implements ISectionServicePort {
    private ISectionPersistencePort sectionPersistencePort;

    public SectionUseCase(ISectionPersistencePort sectionPersistencePort) {
        this.sectionPersistencePort = sectionPersistencePort;
    }

    @Override
    public SectionModel create(SectionModel sectionModel) {
        return sectionPersistencePort.create(sectionModel);
    }

    @Override
    public SectionModel find(Long id) {
        return sectionPersistencePort.find(id);
    }

    @Override
    public List<SectionModel> findAll() {
        return sectionPersistencePort.findAll();
    }

    @Override
    public SectionModel delete(Long id) {
        return sectionPersistencePort.delete(id);
    }
}

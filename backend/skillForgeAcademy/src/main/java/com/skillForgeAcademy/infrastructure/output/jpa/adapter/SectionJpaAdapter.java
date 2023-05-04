package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.SectionModel;
import com.skillForgeAcademy.domain.spi.persistence.ISectionPersistencePort;

import java.util.List;

public class SectionJpaAdapter implements ISectionPersistencePort {
    @Override
    public SectionModel create(SectionModel sectionModel) {
        return null;
    }

    @Override
    public SectionModel find(Long id) {
        return null;
    }

    @Override
    public List<SectionModel> findAll() {
        return null;
    }

    @Override
    public SectionModel delete(Long id) {
        return null;
    }
}

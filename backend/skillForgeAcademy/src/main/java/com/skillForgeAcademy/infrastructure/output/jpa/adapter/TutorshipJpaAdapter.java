package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;

import java.util.List;

public class TutorshipJpaAdapter implements ITutorshipPersistencePort {
    @Override
    public TutorshipModel create(TutorshipModel tutorshipModel) {
        return null;
    }

    @Override
    public TutorshipModel find(Long id) {
        return null;
    }

    @Override
    public List<TutorshipModel> findAll() {
        return null;
    }

    @Override
    public TutorshipModel delete(Long id) {
        return null;
    }
}

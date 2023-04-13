package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ITutorshipServicePort;
import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;

import java.util.List;

public class TutorshipUseCase implements ITutorshipServicePort {
    private ITutorshipPersistencePort tutorshipPersistencePort;

    public TutorshipUseCase(ITutorshipPersistencePort persistencePort) {
        this.tutorshipPersistencePort = persistencePort;
    }

    @Override
    public TutorshipModel create(TutorshipModel tutorshipModel) {
        return tutorshipPersistencePort.create(tutorshipModel);
    }

    @Override
    public TutorshipModel find(Long id) {
        return tutorshipPersistencePort.find(id);
    }

    @Override
    public List<TutorshipModel> findAll() {
        return tutorshipPersistencePort.findAll();
    }

    @Override
    public TutorshipModel delete(Long id) {
        return tutorshipPersistencePort.delete(id);
    }
}

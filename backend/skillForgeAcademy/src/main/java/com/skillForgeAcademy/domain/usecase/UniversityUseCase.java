package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IUniversityServicePort;
import com.skillForgeAcademy.domain.model.UniversityModel;
import com.skillForgeAcademy.domain.spi.persistence.IUniversityPersistencePort;

import java.util.List;

public class UniversityUseCase implements IUniversityServicePort {

    private final IUniversityPersistencePort universityRepository;

    public UniversityUseCase(IUniversityPersistencePort universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public UniversityModel create(UniversityModel universityModel) {
        return this.universityRepository.create(universityModel);
    }

    @Override
    public UniversityModel find(Long id) {
        return this.universityRepository.find(id);
    }

    @Override
    public List<UniversityModel> findAll() {
        return this.universityRepository.findAll();
    }

    @Override
    public UniversityModel delete(Long id) {
        return this.universityRepository.delete(id);
    }
}

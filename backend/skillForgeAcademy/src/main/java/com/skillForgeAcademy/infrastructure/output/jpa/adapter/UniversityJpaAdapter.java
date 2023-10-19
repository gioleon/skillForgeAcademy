package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.UniversityModel;
import com.skillForgeAcademy.domain.spi.persistence.IUniversityPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UniversityEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IUniversityEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IUniversityRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UniversityJpaAdapter implements IUniversityPersistencePort {
    private final IUniversityRepository universityRepository;
    private final IUniversityEntityMapper universityEntityMapper;


    @Override
    public UniversityModel create(UniversityModel universityModel) {
        UniversityEntity universityEntity =
                universityRepository.save(
                        universityEntityMapper.toEntity(universityModel));

        return universityEntityMapper.toModel(universityEntity);
    }

    @Override
    public UniversityModel find(Long id) {
        Optional<UniversityEntity> universityEntity = universityRepository.findById(id);
        if (universityEntity.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }

        return universityEntityMapper.toModel(universityEntity.get());
    }

    @Override
    public List<UniversityModel> findAll() {
        return universityEntityMapper.toModelList(
                (List<UniversityEntity>) universityRepository.findAll());
    }

    @Override
    public UniversityModel delete(Long id) {
        Optional<UniversityEntity> universityEntity = universityRepository.findById(id);
        if (universityEntity.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        universityRepository.deleteById(id);
        return universityEntityMapper.toModel(universityEntity.get());
    }
}

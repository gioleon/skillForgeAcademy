package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.spi.persistence.IRolPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRolEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IRolRepository;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RolJpaAdapter implements IRolPersistencePort {


    private final IRolRepository repository;
    private final IRolEntityMapper rolEntityMapper;

    @Override
    public RolModel create(RolModel rol) {
        RolEntity rolEntity = repository.save(rolEntityMapper.toEntity(rol));
        return rolEntityMapper.toModel(rolEntity);
    }

    @Override
    public RolModel find(Integer id) {
        Optional<RolEntity> rol = this.repository.findById(id);
        if (rol.isEmpty()){
            throw new NoDataFoundException();
        }
        return rolEntityMapper.toModel(rol.get());
    }

    @Override
    public List<RolModel> findAll() {
        List<RolEntity> rolEntities = (List<RolEntity>) repository.findAll();
        if (rolEntities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return rolEntityMapper.toModelList(rolEntities);
    }

    @Override
    public RolModel delete(Integer id) {
        Optional<RolEntity> rol = repository.findById(id);
        if (rol.isEmpty()){
            throw new NoDataFoundException();
        }
        this.repository.deleteById(id);
        return rolEntityMapper.toModel(rol.get());
    }
}

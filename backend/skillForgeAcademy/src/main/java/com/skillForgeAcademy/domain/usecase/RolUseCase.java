package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.api.IRolServicePort;
import com.skillForgeAcademy.domain.spi.persistence.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    private IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort){
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public RolModel create(RolModel rol) {
        return this.rolPersistencePort.create(rol);
    }

    @Override
    public RolModel find(Integer id) {
        return this.rolPersistencePort.find(id);
    }

    @Override
    public List<RolModel> findAll() {
        return this.rolPersistencePort.findAll();
    }

    @Override
    public RolModel delete(Integer id) {
        return this.rolPersistencePort.delete(id);
    }
}

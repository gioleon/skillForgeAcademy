package com.skillForgeAcademy.models.rol.domain.service;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.rol.domain.ports.input.RolServicePort;
import com.skillForgeAcademy.models.rol.domain.ports.output.RolPersistencePort;

public class RolServiceImpl implements RolServicePort {

    private RolPersistencePort rolPersistencePort;

    public RolServiceImpl(RolPersistencePort rolPersistencePort){
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public Rol create(Rol rol) {
        return this.rolPersistencePort.create(rol);
    }

    @Override
    public Rol find(Integer id) {
        return this.rolPersistencePort.find(id);
    }

    @Override
    public Iterable<Rol> findAll() {
        return this.rolPersistencePort.findAll();
    }

    @Override
    public Rol delete(Integer id) throws Exception {
        return this.rolPersistencePort.delete(id);
    }
}

package com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.service;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.rol.domain.ports.input.RolServicePort;
import com.skillForgeAcademy.models.rol.domain.ports.output.RolPersistencePort;
import com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.entity.RolEntity;
import com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.repository.PostgresRolEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolPostgresAdapter implements RolPersistencePort {

    @Autowired
    private PostgresRolEntityRepository repository;

    @Override
    public Rol create(Rol rol) {
        return this.repository.save(rol.toRolEntity()).toRol();
    }

    @Override
    public Rol find(Integer id) {
        Optional<RolEntity> rol = this.repository.findById(id);

        return !rol.isEmpty() ? rol.get().toRol() : null;
    }

    @Override
    public Iterable<Rol> findAll() {
        List<Rol> listRol = (List<Rol>)
                ((List<RolEntity>) this.repository.findAll())
                        .stream()
                        .map(rolEntity -> rolEntity.toRol())
                        .collect(Collectors.toList());
        return listRol;
    }

    @Override
    public Rol delete(Integer id) throws Exception {

        Rol rol = this.find(id);

        if (rol == null){
            throw new Exception("USER NOT EXISTS");
        }

        this.repository.deleteById(id);

        return rol;
    }
}
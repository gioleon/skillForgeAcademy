package com.skillForgeAcademy.rol.infrastructure.service;

import com.skillForgeAcademy.rol.domain.model.Rol;
import com.skillForgeAcademy.rol.domain.service.RolService;
import com.skillForgeAcademy.rol.infrastructure.entity.RolEntity;
import com.skillForgeAcademy.rol.infrastructure.repository.PostgresRolEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolEntityServiceImpl implements RolService {

    private PostgresRolEntityRepository repository;

    public RolEntityServiceImpl(PostgresRolEntityRepository repository){
        this.repository = repository;
    }

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

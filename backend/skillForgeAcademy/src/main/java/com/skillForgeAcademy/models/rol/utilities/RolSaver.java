package com.skillForgeAcademy.models.rol.utilities;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.rol.domain.ports.input.RolServicePort;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolSaver {

    @Autowired
    private RolServicePort repository;

    @PostConstruct
    void SaveRoles() {
        Rol user = new Rol("ROLE_USER");
        Rol admin = new Rol("ROLE_ADMIN");

        if (((List<Rol>) this.repository.findAll()).toArray().length == 0) {

            this.repository.create(user);
            this.repository.create(admin);
        }

    }
}

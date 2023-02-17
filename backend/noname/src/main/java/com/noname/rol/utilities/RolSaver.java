package com.noname.rol.utilities;

import com.noname.rol.domain.model.Rol;
import com.noname.rol.domain.service.RolService;
import com.noname.rol.infrastructure.service.RolEntityServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolSaver {

    private RolService repository;

    RolSaver(RolEntityServiceImpl repository) {
        this.repository = repository;
    }

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

package com.skillForgeAcademy.infrastructure.component;

import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.api.IRolServicePort;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolSaver {

    @Autowired
    private IRolServicePort repository;

    @PostConstruct
    void SaveRoles() {
        RolModel user = new RolModel("ROLE_USER");
        RolModel admin = new RolModel("ROLE_ADMIN");

        if (((List<RolModel>) this.repository.findAll()).toArray().length == 0) {

            this.repository.create(user);
            this.repository.create(admin);
        }

    }
}

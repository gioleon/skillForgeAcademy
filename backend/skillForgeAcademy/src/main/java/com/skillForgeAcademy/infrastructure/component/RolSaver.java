package com.skillForgeAcademy.infrastructure.component;

import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.api.IRolServicePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRolEntityMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RolSaver {

    private final IRolServicePort repository;
    private final IRolEntityMapper rolEntityMapper;

    @PostConstruct
    void SaveRoles() {
        RolEntity user = new RolEntity();
        user.setName("ROLE_USER");
        RolEntity admin = new RolEntity();
        admin.setName("ROLE_ADMIN");

        try {
            this.repository.findAll();
        } catch (NoDataFoundException rx) {
            this.repository.create(rolEntityMapper.toModel(user));
            this.repository.create(rolEntityMapper.toModel(admin));
        }
    }
}

package com.skillForgeAcademy.models.rol.infrastructure.config;

import com.skillForgeAcademy.models.rol.domain.ports.input.RolServicePort;
import com.skillForgeAcademy.models.rol.domain.ports.output.RolPersistencePort;
import com.skillForgeAcademy.models.rol.domain.service.RolServiceImpl;
import com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.service.RolPostgresAdapter;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RolConfig {
    @Bean
    public RolPersistencePort rolPersistence(){
        return new RolPostgresAdapter();
    }

    @Bean
    public RolServicePort rolService(){
        return new RolServiceImpl(rolPersistence());
    }

}

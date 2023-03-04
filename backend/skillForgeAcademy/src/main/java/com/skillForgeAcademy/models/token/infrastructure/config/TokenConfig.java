package com.skillForgeAcademy.models.token.infrastructure.config;

import com.skillForgeAcademy.models.token.domain.ports.input.TokenServicePort;
import com.skillForgeAcademy.models.token.domain.ports.output.TokenPersistencePort;
import com.skillForgeAcademy.models.token.domain.service.TokenServiceImpl;
import com.skillForgeAcademy.models.token.infrastructure.database.service.TokenPostgresAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Bean
    public TokenPersistencePort tokenPersistence() {
        return new TokenPostgresAdapter();
    }

    @Bean
    public TokenServicePort tokenService() {
        return new TokenServiceImpl(tokenPersistence());
    }

}

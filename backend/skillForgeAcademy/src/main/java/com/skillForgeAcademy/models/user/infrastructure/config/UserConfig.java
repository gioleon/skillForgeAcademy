package com.skillForgeAcademy.models.user.infrastructure.config;

import com.skillForgeAcademy.models.user.domain.ports.input.UserServicePort;
import com.skillForgeAcademy.models.user.domain.ports.output.UserPersistencePort;
import com.skillForgeAcademy.models.user.domain.service.UserServiceImpl;
import com.skillForgeAcademy.models.user.infrastructure.postgresAdapter.adapter.UserPostgresAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserPersistencePort userPersistence(){
        return new UserPostgresAdapter();
    }

    @Bean
    public UserServicePort userService(){
        return new UserServiceImpl(userPersistence());
    }
}

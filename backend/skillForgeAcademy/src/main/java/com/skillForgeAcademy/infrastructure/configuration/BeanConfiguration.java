package com.skillForgeAcademy.infrastructure.configuration;

import com.skillForgeAcademy.domain.api.IRolServicePort;
import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.api.IUserServicePort;
import com.skillForgeAcademy.domain.spi.passwordencoder.IPasswordEncoderPort;
import com.skillForgeAcademy.domain.spi.persistence.IRolPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.ITokenPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IUserPersistencePort;
import com.skillForgeAcademy.domain.usecase.RolUseCase;
import com.skillForgeAcademy.domain.usecase.TokenUseCase;
import com.skillForgeAcademy.domain.usecase.UserUseCase;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.RolJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.TokenJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRolEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITokenEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IRolRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITokenRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IUserRepository;
import com.skillForgeAcademy.infrastructure.output.passwordencoder.PasswordEncoderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRolRepository rolRepository;
    private final IRolEntityMapper rolEntityMapper;
    private final ITokenRepository tokenRepository;
    private final ITokenEntityMapper tokenEntityMapper;


    @Bean
    public IPasswordEncoderPort passwordEncoderPort(){
        return new PasswordEncoderAdapter();
    }

    @Bean
    public IUserPersistencePort userPersistence(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userService(){
        return new UserUseCase(userPersistence(), tokenPersistence(), passwordEncoderPort());
    }

    @Bean
    public IRolPersistencePort rolPersistence(){
        return new RolJpaAdapter(rolRepository, rolEntityMapper);
    }

    @Bean
    public IRolServicePort rolService(){
        return new RolUseCase(rolPersistence());
    }

    @Bean
    public ITokenPersistencePort tokenPersistence() {
        return new TokenJpaAdapter(tokenRepository, tokenEntityMapper);
    }

    @Bean
    public ITokenServicePort tokenService() {
        return new TokenUseCase(tokenPersistence());
    }

}

package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.exception.DomainException;
import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.spi.persistence.ITokenPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TokenUseCase implements ITokenServicePort {

    private ITokenPersistencePort tokenPersistencePort;

    public TokenUseCase(ITokenPersistencePort tokenPersistencePort){
        this.tokenPersistencePort = tokenPersistencePort;
    }

    @Override
    public void confirmToken(String token) {
        TokenModel tokenFound = tokenPersistencePort.findByToken(token);
        if (token == null){
            throw new DomainException("TOKEN NOT FOUND");
        } else if (tokenFound.getExpiredAt().isBefore(LocalDateTime.now())){
            throw new DomainException("TOKEN IS ALREADY EXPIRED");
        } else if (tokenFound.getConfirmedAt() != null) {
            throw new DomainException("TOKEN IS ALREADY CONFIRMED");
        }
        this.tokenPersistencePort.confirmToken(token);
    }

    @Override
    public TokenModel findByToken(String token) {
        return tokenPersistencePort.findByToken(token);
    }

    @Override
    public TokenModel create(TokenModel token) {
        return this.tokenPersistencePort.create(token);
    }

    @Override
    public TokenModel find(String id) {
        return this.tokenPersistencePort.find(id);
    }

    @Override
    public List findAll() {
        return this.tokenPersistencePort.findAll();
    }

    @Override
    public TokenModel delete(String id){
        return this.tokenPersistencePort.delete(id);
    }
}

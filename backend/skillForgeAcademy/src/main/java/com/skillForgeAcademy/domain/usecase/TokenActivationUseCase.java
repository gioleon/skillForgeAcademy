package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.exception.DomainException;
import com.skillForgeAcademy.domain.model.TokenActivationModel;
import com.skillForgeAcademy.domain.api.ITokenActivationServicePort;
import com.skillForgeAcademy.domain.spi.persistence.ITokenActivationPersistencePort;

import java.time.LocalDateTime;
import java.util.List;

public class TokenActivationUseCase implements ITokenActivationServicePort {

    private ITokenActivationPersistencePort tokenPersistencePort;

    public TokenActivationUseCase(ITokenActivationPersistencePort tokenPersistencePort){
        this.tokenPersistencePort = tokenPersistencePort;
    }

    @Override
    public void confirmToken(String token) {
        TokenActivationModel tokenFound = tokenPersistencePort.findByToken(token);
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
    public TokenActivationModel findByToken(String token) {
        return tokenPersistencePort.findByToken(token);
    }

    @Override
    public TokenActivationModel create(TokenActivationModel token) {
        return this.tokenPersistencePort.create(token);
    }

    @Override
    public TokenActivationModel find(String id) {
        return this.tokenPersistencePort.find(id);
    }

    @Override
    public List<TokenActivationModel> findAll() {
        return this.tokenPersistencePort.findAll();
    }

    @Override
    public TokenActivationModel delete(String id){
        return this.tokenPersistencePort.delete(id);
    }
}

package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.spi.persistence.ITokenPersistencePort;

import java.util.List;

public class TokenUseCase implements ITokenServicePort {

    private ITokenPersistencePort tokenPersistencePort;

    public TokenUseCase(ITokenPersistencePort tokenPersistencePort){
        this.tokenPersistencePort = tokenPersistencePort;
    }

    @Override
    public boolean confirmToken(String token) throws Exception {
        return tokenPersistencePort.confirmToken(token);
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

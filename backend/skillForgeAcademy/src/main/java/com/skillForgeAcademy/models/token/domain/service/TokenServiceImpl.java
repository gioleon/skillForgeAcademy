package com.skillForgeAcademy.models.token.domain.service;

import com.skillForgeAcademy.models.token.domain.model.Token;
import com.skillForgeAcademy.models.token.domain.ports.input.TokenServicePort;
import com.skillForgeAcademy.models.token.domain.ports.output.TokenPersistencePort;

public class TokenServiceImpl implements TokenServicePort {

    private TokenPersistencePort tokenPersistencePort;

    public TokenServiceImpl(TokenPersistencePort tokenPersistencePort){
        this.tokenPersistencePort = tokenPersistencePort;
    }

    @Override
    public boolean confirmToken(String token) throws Exception {
        return tokenPersistencePort.confirmToken(token);
    }

    @Override
    public Token create(Token token) {
        return this.tokenPersistencePort.create(token);
    }

    @Override
    public Token find(String id) {
        return this.tokenPersistencePort.find(id);
    }

    @Override
    public Iterable<Token> findAll() {
        return this.tokenPersistencePort.findAll();
    }

    @Override
    public Token delete(String id) throws Exception {
        return this.tokenPersistencePort.delete(id);
    }
}

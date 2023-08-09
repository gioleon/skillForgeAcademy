package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.TokenActivationModel;
import com.skillForgeAcademy.domain.spi.persistence.ITokenActivationPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenActivationEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITokenEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITokenActivationRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenActivationJpaAdapter implements ITokenActivationPersistencePort {

    private final ITokenActivationRepository repository;
    private final ITokenEntityMapper tokenEntityMapper;

    @Override
    public void confirmToken(String token) {
        repository.updateConfirmedAt(token, LocalDateTime.now());
    }

    @Override
    public TokenActivationModel findByToken(String token) {
        Optional<TokenActivationEntity> tokenEntity = repository.findByToken(token);
        if (tokenEntity.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return tokenEntityMapper.toModel(tokenEntity.get());
    }

    @Override
    public TokenActivationModel create(TokenActivationModel token) {
        TokenActivationEntity tokenEntity = tokenEntityMapper.toEntity(token);
        return tokenEntityMapper.toModel(repository.save(tokenEntity));
    }

    @Override
    public TokenActivationModel find(String token) {
        Optional<TokenActivationEntity> tokenFound = this.repository.findByToken(token);
        if (tokenFound.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return tokenEntityMapper.toModel(tokenFound.get());
    }

    @Override
    public List<TokenActivationModel> findAll() {
        List<TokenActivationEntity> tokenEntities = (List<TokenActivationEntity>) repository.findAll();
        if (tokenEntities.isEmpty()){
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return tokenEntityMapper.toModelList(tokenEntities);
    }

    @Override
    public TokenActivationModel delete(String token){
        Optional<TokenActivationEntity> tokenFound = repository.findByToken(token);
        if (token.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        this.repository.deleteById(tokenFound.get().getId());
        return tokenEntityMapper.toModel(tokenFound.get());
    }
}

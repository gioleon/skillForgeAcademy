package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.spi.persistence.ITokenPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITokenEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenJpaAdapter implements ITokenPersistencePort {

    private final ITokenRepository repository;
    private final ITokenEntityMapper tokenEntityMapper;

    @Override
    public void confirmToken(String token) {
        repository.updateConfirmedAt(token, LocalDateTime.now());
    }

    @Override
    public TokenModel findByToken(String token) {
        Optional<TokenEntity> tokenEntity = repository.findByToken(token);
        if (tokenEntity.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return tokenEntityMapper.toModel(tokenEntity.get());
    }

    @Override
    public TokenModel create(TokenModel token) {
        TokenEntity tokenEntity = tokenEntityMapper.toEntity(token);
        return tokenEntityMapper.toModel(repository.save(tokenEntity));
    }

    @Override
    public TokenModel find(String token) {
        Optional<TokenEntity> tokenFound = this.repository.findByToken(token);
        if (tokenFound.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return tokenEntityMapper.toModel(tokenFound.get());
    }

    @Override
    public List<TokenModel> findAll() {
        List<TokenEntity> tokenEntities = (List<TokenEntity>) repository.findAll();
        if (tokenEntities.isEmpty()){
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return tokenEntityMapper.toModelList(tokenEntities);
    }

    @Override
    public TokenModel delete(String token){
        Optional<TokenEntity> tokenFound = repository.findByToken(token);
        if (token.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        this.repository.deleteById(tokenFound.get().getId());
        return tokenEntityMapper.toModel(tokenFound.get());
    }
}

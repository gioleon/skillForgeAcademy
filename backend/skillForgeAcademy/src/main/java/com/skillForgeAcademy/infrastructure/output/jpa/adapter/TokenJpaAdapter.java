package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.spi.persistence.ITokenPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITokenEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class TokenJpaAdapter implements ITokenPersistencePort {

    private final ITokenRepository repository;
    private final ITokenEntityMapper tokenEntityMapper;

    @Override
    public boolean confirmToken(String token) throws Exception {

        boolean tokenValidity = true;

        TokenModel tokenFound = this.find(token);

        if (token == null){
            log.warn("ERROR! TOKEN NOT FOUND: {}", tokenFound.getToken());
            throw new Exception("TOKEN NOT FOUND");
        } else if (tokenFound.getExpiredAt().isBefore(LocalDateTime.now())){
            log.warn("ERROR! TOKEN IS ALREADY EXPIRE: {}", tokenFound.getToken());
            throw new Exception("TOKEN IS ALREADY EXPIRED");
        } else if (tokenFound.getConfirmedAt() != null) {
            log.warn("ERROR! TOKEN IS ALREADY CONFIRMED: {}", tokenFound.getToken());
            throw new Exception("TOKEN IS ALREADY CONFIRMED");
        }

        this.repository.updateConfirmedAt(tokenFound.getToken(), LocalDateTime.now());

        return tokenValidity;
    }

    @Override
    public TokenModel create(TokenModel token) {
        TokenEntity tokenEntity = repository.save(tokenEntityMapper.toEntity(token));
        return tokenEntityMapper.toModel(tokenEntity);
    }

    @Override
    public TokenModel find(String token) {
        Optional<TokenEntity> tokenFound = this.repository.findByToken(token);
        if (tokenFound.isEmpty()) {
            throw new NoDataFoundException();
        }
        return tokenEntityMapper.toModel(tokenFound.get());
    }

    @Override
    public List findAll() {
        List<TokenEntity> tokenEntities = (List<TokenEntity>) repository.findAll();
        if (tokenEntities.isEmpty()){
            throw new NoDataFoundException();
        }
        return tokenEntityMapper.toModelList(tokenEntities);
    }

    @Override
    public TokenModel delete(String token){
        Optional<TokenEntity> tokenFound = repository.findByToken(token);
        if (token.isEmpty()) {
            throw new NoDataFoundException();
        }
        this.repository.deleteById(tokenFound.get().getId());
        return tokenEntityMapper.toModel(tokenFound.get());
    }
}

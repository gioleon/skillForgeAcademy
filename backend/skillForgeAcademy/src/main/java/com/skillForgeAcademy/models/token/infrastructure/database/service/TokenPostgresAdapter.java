package com.skillForgeAcademy.models.token.infrastructure.database.service;

import com.skillForgeAcademy.models.token.domain.model.Token;
import com.skillForgeAcademy.models.token.domain.ports.input.TokenServicePort;
import com.skillForgeAcademy.models.token.domain.ports.output.TokenPersistencePort;
import com.skillForgeAcademy.models.token.infrastructure.database.entity.TokenEntity;
import com.skillForgeAcademy.models.token.infrastructure.database.repository.PostgresTokenEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TokenPostgresAdapter implements TokenPersistencePort {

    @Autowired
    private PostgresTokenEntityRepository repository;

    @Override
    public boolean confirmToken(String token) throws Exception {

        boolean tokenValidity = true;

        Token tokenFound = this.find(token);

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
    public Token create(Token token) {

        TokenEntity tokenEntity = token.toTokenEntity();

        return this.repository.save(token.toTokenEntity()).toToken();
    }

    @Override
    public Token find(String token) {
        Optional<TokenEntity> tokenFound = this.repository.findByToken(token);

        if (tokenFound.isEmpty()) {
            return null;
        }
        return tokenFound.get().toToken();
    }

    @Override
    public Iterable<Token> findAll() {
        return ((List<TokenEntity>) this.repository.findAll())
                .stream()
                .map(tokenEntity -> tokenEntity.toToken())
                .collect(Collectors.toList());
    }

    @Override
    public Token delete(String token) throws Exception {
        Token tokenFound = this.find(token);

        if (token == null) {
            log.warn("ERROR! TOKEN NOT EXISTS: {}", tokenFound.getToken());
            throw new Exception("TOKEN NOT EXISTS");
        }

        this.repository.deleteById(tokenFound.getId());

        return tokenFound;
    }
}

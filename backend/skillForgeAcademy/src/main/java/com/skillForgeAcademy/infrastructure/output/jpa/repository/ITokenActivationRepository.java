package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenActivationEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ITokenActivationRepository extends CrudRepository<TokenActivationEntity, Long> {

    Optional<TokenActivationEntity> findByToken(String token);
    @Transactional
    @Modifying
    @Query(value = "UPDATE tokens SET confirmed_at = :confirmedAt WHERE token = :token", nativeQuery = true)
    int updateConfirmedAt(@Param("token") String token,
                          @Param("confirmedAt")LocalDateTime confirmedAt);
}

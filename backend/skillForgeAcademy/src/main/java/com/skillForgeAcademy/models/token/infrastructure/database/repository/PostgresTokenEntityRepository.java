package com.skillForgeAcademy.models.token.infrastructure.database.repository;

import com.skillForgeAcademy.models.token.infrastructure.database.entity.TokenEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PostgresTokenEntityRepository extends CrudRepository<TokenEntity, Long> {

    Optional<TokenEntity> findByToken(String token);
    @Transactional
    @Modifying
    @Query(value = "UPDATE tokens SET confirmed_at = :confirmedAt WHERE token = :token", nativeQuery = true)
    int updateConfirmedAt(@Param("token") String token,
                          @Param("confirmedAt")LocalDateTime confirmedAt);
}

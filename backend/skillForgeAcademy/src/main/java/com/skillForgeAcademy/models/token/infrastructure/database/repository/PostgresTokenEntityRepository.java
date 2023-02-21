package com.skillForgeAcademy.models.token.infrastructure.database.repository;

import com.skillForgeAcademy.models.token.infrastructure.database.entity.TokenEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PostgresTokenEntityRepository extends CrudRepository<TokenEntity, Long> {

    Optional<TokenEntity> findByToken(String token);
    @Modifying
    @Query("UPDATE token t SET t.confirmedAt = :confirmedAt WHERE t.token = :token")
    int updateConfirmedAt(@Param("token") String token,
                          @Param("confirmedAt")LocalDateTime confirmedAt);
}

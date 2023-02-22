package com.skillForgeAcademy.models.user.infrastructure.database.repository;

import com.skillForgeAcademy.models.user.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PostgresUserEntityRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET is_enable = true WHERE id = :userId", nativeQuery = true)
    int updateIsEnable(@Param("userId") long userId);

}

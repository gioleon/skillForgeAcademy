package com.skillForgeAcademy.models.user.infrastructure.database.repository;

import com.skillForgeAcademy.models.user.infrastructure.database.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostgresUserEntityRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}

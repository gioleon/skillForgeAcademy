package com.skillForgeAcademy.user.infrastructure.database.repository;

import com.skillForgeAcademy.user.infrastructure.database.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresUserEntityRepository extends CrudRepository<UserEntity, Long> {

}

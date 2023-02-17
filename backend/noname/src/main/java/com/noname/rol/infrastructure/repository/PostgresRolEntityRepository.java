package com.noname.rol.infrastructure.repository;

import com.noname.rol.infrastructure.entity.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRolEntityRepository extends CrudRepository<RolEntity, Integer> {
}

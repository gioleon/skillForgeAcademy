package com.skillForgeAcademy.models.rol.infrastructure.repository;

import com.skillForgeAcademy.models.rol.infrastructure.entity.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRolEntityRepository extends CrudRepository<RolEntity, Integer> {
}

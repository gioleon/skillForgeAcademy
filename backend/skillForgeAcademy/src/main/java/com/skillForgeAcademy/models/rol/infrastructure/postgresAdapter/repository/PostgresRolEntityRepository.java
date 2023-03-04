package com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.repository;

import com.skillForgeAcademy.models.rol.infrastructure.postgresAdapter.entity.RolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresRolEntityRepository extends CrudRepository<RolEntity, Integer> {
}

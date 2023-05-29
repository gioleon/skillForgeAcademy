package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.SectionEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.SectionEntityId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISectionRepository extends CrudRepository<SectionEntity, SectionEntityId> {
  @Query(value = "SELECT MAX(id) FROM sections", nativeQuery = true)
  Long findLastId();
}

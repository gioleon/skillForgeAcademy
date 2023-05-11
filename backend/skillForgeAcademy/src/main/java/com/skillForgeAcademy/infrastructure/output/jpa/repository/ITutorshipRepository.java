package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntityId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITutorshipRepository
  extends CrudRepository<TutorshipEntity, TutorshipEntityId> {}

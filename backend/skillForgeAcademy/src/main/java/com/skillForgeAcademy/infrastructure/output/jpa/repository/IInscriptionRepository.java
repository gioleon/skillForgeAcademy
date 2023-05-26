package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IInscriptionRepository
    extends CrudRepository<InscriptionEntity, InscriptionEntityId> {

  List<InscriptionEntity> findByStudent(UserEntity user);
}

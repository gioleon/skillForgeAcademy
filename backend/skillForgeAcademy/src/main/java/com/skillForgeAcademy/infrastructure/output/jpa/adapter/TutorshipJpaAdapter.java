package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITutorshipEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITutorshipEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITutorshipRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TutorshipJpaAdapter implements ITutorshipPersistencePort {

  private final ITutorshipRepository tutorshipRepository;
  private final ITutorshipEntityMapper tutorshipEntityMapper;
  private final ITutorshipEntityIdMapper tutorshipEntityIdMapper;

  @Override
  public TutorshipModel create(TutorshipModel tutorshipModel) {
    TutorshipEntity tutorshipEntity = tutorshipRepository.save(
      tutorshipEntityMapper.toEntity(tutorshipModel)
    );

    return tutorshipEntityMapper.toModel(tutorshipEntity);
  }

  @Override
  public List<TutorshipModel> findAll() {
    return tutorshipEntityMapper.toModelList(
      (List<TutorshipEntity>) tutorshipRepository.findAll()
    );
  }

  @Override
  public TutorshipModel find(TutorshipModelId id) {
    TutorshipEntityId tutorshipEntityId = tutorshipEntityIdMapper.toEntityId(
      id
    );
    Optional<TutorshipEntity> tutorshipEntity = tutorshipRepository.findById(
      tutorshipEntityId
    );

    if (tutorshipEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }

    return tutorshipEntityMapper.toModel(tutorshipEntity.get());
  }

  @Override
  public TutorshipModel delete(TutorshipModelId id) {
    TutorshipEntityId tutorshipEntityId = tutorshipEntityIdMapper.toEntityId(
      id
    );
    Optional<TutorshipEntity> tutorshipEntity = tutorshipRepository.findById(
      tutorshipEntityId
    );

    if (tutorshipEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }

    tutorshipRepository.deleteById(tutorshipEntityId);
    return tutorshipEntityMapper.toModel(tutorshipEntity.get());
  }
}

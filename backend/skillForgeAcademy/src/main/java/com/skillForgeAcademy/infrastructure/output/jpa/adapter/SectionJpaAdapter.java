package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.SectionModel;
import com.skillForgeAcademy.domain.model.SectionModelId;
import com.skillForgeAcademy.domain.spi.persistence.ISectionPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.SectionEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.SectionEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ISectionEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ISectionEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ISectionRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SectionJpaAdapter implements ISectionPersistencePort {

  private final ISectionRepository sectionRepository;
  private final ISectionEntityMapper sectionEntityMapper;
  private final ISectionEntityIdMapper sectionEntityIdMapper;

  @Override
  public SectionModel create(SectionModel sectionModel) {
    SectionEntity sectionEntity = sectionRepository.save(
      sectionEntityMapper.toEntity(sectionModel)
    );
    return sectionEntityMapper.toModel(sectionEntity);
  }

  @Override
  public List<SectionModel> findAll() {
    return sectionEntityMapper.toModelList(
      (List<SectionEntity>) sectionRepository.findAll()
    );
  }

  @Override
  public SectionModel find(SectionModelId id) {
    SectionEntityId sectionEntityId = sectionEntityIdMapper.toEntityId(id);
    Optional<SectionEntity> sectionEntity = sectionRepository.findById(
      sectionEntityId
    );

    if (sectionEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    return sectionEntityMapper.toModel(sectionEntity.get());
  }

  @Override
  public SectionModel delete(SectionModelId id) {
    SectionEntityId sectionEntityId = sectionEntityIdMapper.toEntityId(id);
    Optional<SectionEntity> sectionEntity = sectionRepository.findById(
      sectionEntityId
    );

    if (sectionEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    sectionRepository.deleteById(sectionEntityId);
    return sectionEntityMapper.toModel(sectionEntity.get());
  }
}

package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.model.RateModelId;
import com.skillForgeAcademy.domain.spi.persistence.IRatePersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRateEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRateEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IRateRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RateJpaAdapter implements IRatePersistencePort {

  private final IRateRepository rateRepository;
  private final IRateEntityMapper rateEntityMapper;
  private final IRateEntityIdMapper rateEntityIdMapper;

  @Override
  public RateModel create(RateModel rateModel) {
    RateEntity rateEntity = rateRepository.save(
      rateEntityMapper.toEntity(rateModel)
    );
    return rateEntityMapper.toModel(rateEntity);
  }

  @Override
  public List<RateModel> findAll() {
    return rateEntityMapper.toModelList(
      (List<RateEntity>) rateRepository.findAll()
    );
  }

  @Override
  public RateModel find(RateModelId id) {
    RateEntityId rateEntityId = rateEntityIdMapper.toEntityId(id);
    Optional<RateEntity> rateEntity = rateRepository.findById(rateEntityId);
    if (rateEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    return rateEntityMapper.toModel(rateEntity.get());
  }

  @Override
  public RateModel delete(RateModelId id) {
    RateEntityId rateEntityId = rateEntityIdMapper.toEntityId(id);
    Optional<RateEntity> rateEntity = rateRepository.findById(rateEntityId);
    if (rateEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }

    rateRepository.deleteById(rateEntityId);

    return rateEntityMapper.toModel(rateEntity.get());
  }
}

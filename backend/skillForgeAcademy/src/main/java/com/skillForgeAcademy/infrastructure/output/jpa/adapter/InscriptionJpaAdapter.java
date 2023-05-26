package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.InscriptionModel;
import com.skillForgeAcademy.domain.model.InscriptionModelId;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.spi.persistence.IInscriptionPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IInscriptionEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IInscriptionEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IInscriptionRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InscriptionJpaAdapter implements IInscriptionPersistencePort {
  private final IInscriptionRepository inscriptionRepository;
  private final IInscriptionEntityIdMapper inscriptionEntityIdMapper;
  private final IInscriptionEntityMapper inscriptionEntityMapper;
  private final IUserEntityMapper userEntityMapper;

  @Override
  public InscriptionModel create(InscriptionModel inscriptionModel) {
    return inscriptionEntityMapper.toModel(
        inscriptionRepository.save(inscriptionEntityMapper.toEntity(inscriptionModel)));
  }

  @Override
  public InscriptionModel find(InscriptionModelId id) {
    Optional<InscriptionEntity> inscriptionModel =
        inscriptionRepository.findById(inscriptionEntityIdMapper.toEntity(id));
    if (inscriptionModel.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUD");
    }
    return inscriptionEntityMapper.toModel(inscriptionModel.get());
  }

  @Override
  public List<InscriptionModel> findAll() {
    return inscriptionEntityMapper.toModelList(
        (List<InscriptionEntity>) inscriptionRepository.findAll());
  }

  @Override
  public InscriptionModel delete(InscriptionModelId id) {
    Optional<InscriptionEntity> inscriptionModel =
        inscriptionRepository.findById(inscriptionEntityIdMapper.toEntity(id));
    if (inscriptionModel.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUD");
    }
    inscriptionRepository.delete(inscriptionModel.get());
    return inscriptionEntityMapper.toModel(inscriptionModel.get());
  }

  @Override
  public List<InscriptionModel> findByStudent(UserModel user) {
    return inscriptionEntityMapper.toModelList(
        inscriptionRepository.findByStudent(userEntityMapper.toEntity(user)));
  }
}

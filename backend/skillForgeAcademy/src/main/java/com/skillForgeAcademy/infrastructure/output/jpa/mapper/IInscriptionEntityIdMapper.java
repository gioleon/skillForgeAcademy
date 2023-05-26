package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.InscriptionModelId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntityId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IInscriptionEntityIdMapper {
  InscriptionModelId toModel(InscriptionEntityId inscriptionEntityId);

  InscriptionEntityId toEntity(InscriptionModelId inscriptionModelId);
}

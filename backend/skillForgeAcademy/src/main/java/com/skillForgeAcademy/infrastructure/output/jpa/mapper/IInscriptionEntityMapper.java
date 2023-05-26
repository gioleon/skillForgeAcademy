package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.InscriptionModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IInscriptionEntityMapper {
  InscriptionModel toModel(InscriptionEntity inscriptionEntity);

  InscriptionEntity toEntity(InscriptionModel inscriptionModel);

  List<InscriptionModel> toModelList(List<InscriptionEntity> inscriptionEntities);
}

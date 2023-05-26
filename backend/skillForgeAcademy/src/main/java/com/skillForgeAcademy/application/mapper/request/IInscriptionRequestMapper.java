package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.InscriptionRequestDto;
import com.skillForgeAcademy.domain.model.InscriptionModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IInscriptionRequestMapper {

  InscriptionModel toModel(InscriptionRequestDto inscriptionRequestDto);
}

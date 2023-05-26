package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.InscriptionResponseDto;
import com.skillForgeAcademy.domain.model.InscriptionModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IInscriptionResponseMapper {
    InscriptionResponseDto toResponse(InscriptionModel inscriptionModel);
    List<InscriptionResponseDto> toResponseList(List<InscriptionModel> inscriptionModels);
}

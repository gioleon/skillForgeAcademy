package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.TokenResponseDto;
import com.skillForgeAcademy.domain.model.TokenActivationModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITokenResponseMapper {
    TokenResponseDto toResponse(TokenActivationModel tokenModel);

}

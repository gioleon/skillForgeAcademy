package com.skillForgeAcademy.application.mapper;


import com.skillForgeAcademy.application.dto.response.TokenResponseDto;
import com.skillForgeAcademy.domain.model.TokenModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITokenResponseMapper {
    TokenResponseDto toResponse(TokenModel tokenModel);

}

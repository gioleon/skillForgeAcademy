package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.response.RolResponseDto;
import com.skillForgeAcademy.domain.model.RolModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRolRequestMapper {

    RolModel toModel(RolResponseDto rolResponseDto);

}
package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.UniversityRequestDto;
import com.skillForgeAcademy.domain.model.UniversityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUniversityRequestMapper {
    UniversityModel toModel(UniversityRequestDto universityRequestDto);
}

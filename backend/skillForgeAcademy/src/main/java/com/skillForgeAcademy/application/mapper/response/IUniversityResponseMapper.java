package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.UniversityResponseDto;
import com.skillForgeAcademy.domain.model.UniversityModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUniversityResponseMapper {
    UniversityResponseDto toResponse(UniversityModel universityModel);
    List<UniversityResponseDto> toResponseList(List<UniversityModel> universityModelList);
}

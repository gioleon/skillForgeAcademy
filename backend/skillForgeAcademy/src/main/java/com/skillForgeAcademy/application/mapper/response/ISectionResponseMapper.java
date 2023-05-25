package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.SectionResponseDto;
import com.skillForgeAcademy.domain.model.SectionModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISectionResponseMapper {
    SectionResponseDto toResponse(SectionModel sectionModel);
    List<SectionResponseDto> toResponseList(List<SectionModel> sections);
}

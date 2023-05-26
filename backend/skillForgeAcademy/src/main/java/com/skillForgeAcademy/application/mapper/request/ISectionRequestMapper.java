package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.SectionRequestDto;
import com.skillForgeAcademy.domain.model.SectionModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISectionRequestMapper {

  SectionModel toModel(SectionRequestDto sectionRequestDto);
}

package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.SectionRequestIdDto;
import com.skillForgeAcademy.domain.model.SectionModelId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISectionRequestIdMapper {
  SectionModelId toModel(SectionRequestIdDto sectionRequestIdDto);
}

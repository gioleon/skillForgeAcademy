package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.skillForgeAcademy.domain.model.SectionModelId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.SectionEntityId;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ISectionEntityIdMapper {
    SectionEntityId toEntityId(SectionModelId sectionModelId);
    SectionModelId toModelId(SectionEntityId sectionEntityId);
}

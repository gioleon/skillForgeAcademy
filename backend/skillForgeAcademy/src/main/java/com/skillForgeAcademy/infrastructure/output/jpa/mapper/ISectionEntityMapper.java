package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.SectionModel;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.SectionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISectionEntityMapper {
    SectionModel toModel( SectionEntity sectionEntity);
    SectionEntity toEntity(SectionModel  sectionModel);
    List<SectionModel> toModelList(List< SectionEntity> sectionEntities);
}

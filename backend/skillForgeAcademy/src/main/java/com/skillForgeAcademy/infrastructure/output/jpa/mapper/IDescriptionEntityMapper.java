package com.skillForgeAcademy.infrastructure.output.jpa.mapper;


import com.skillForgeAcademy.domain.model.DescriptionModel;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.DescriptionEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IDescriptionEntityMapper {
    DescriptionModel toModel(DescriptionEntity descriptionEntity);
    DescriptionEntity toEntity(DescriptionModel descriptionModel);
    List<DescriptionModel> toModelList(List<DescriptionEntity> descriptionEntities);
}

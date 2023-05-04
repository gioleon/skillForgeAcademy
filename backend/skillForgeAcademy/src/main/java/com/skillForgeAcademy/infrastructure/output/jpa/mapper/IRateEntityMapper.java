package com.skillForgeAcademy.infrastructure.output.jpa.mapper;


import com.skillForgeAcademy.domain.model.RateModel;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRateEntityMapper {
    RateModel toModel(RateEntity rateEntity);
    RateEntity toEntity(RateModel rateModel);
    List<RateModel> toModelList(List<RateEntity> rateEntities);
}

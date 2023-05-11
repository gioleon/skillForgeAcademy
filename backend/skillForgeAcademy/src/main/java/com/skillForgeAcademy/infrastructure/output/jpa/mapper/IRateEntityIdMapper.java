package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.skillForgeAcademy.domain.model.RateModelId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntityId;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IRateEntityIdMapper {
    RateEntityId toEntityId(RateModelId rateModelId);
    RateModelId toModelId(RateEntityId rateEntityId);
}

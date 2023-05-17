package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.RateRequestIdDto;
import com.skillForgeAcademy.domain.model.RateModelId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRateRequestIdMapper {
  RateModelId toModel(RateRequestIdDto rateRequestIdDto);
}

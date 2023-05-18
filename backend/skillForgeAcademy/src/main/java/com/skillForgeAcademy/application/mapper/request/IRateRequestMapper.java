package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.RateRequestDto;
import com.skillForgeAcademy.domain.model.RateModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRateRequestMapper {
  RateModel toModel(RateRequestDto rateRequestDto);
}

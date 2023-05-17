package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.RateResponseIdDto;
import com.skillForgeAcademy.domain.model.RateModelId;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRateResponseIdMapper {
  RateResponseIdDto toResponse(RateModelId rateModelId);

  List<RateResponseIdDto> toResponseList(List<RateModelId> rateModelIdList);
}

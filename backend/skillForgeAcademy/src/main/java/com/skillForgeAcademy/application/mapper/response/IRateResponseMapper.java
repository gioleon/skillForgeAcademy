package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.RateResponseDto;
import com.skillForgeAcademy.domain.model.RateModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRateResponseMapper {
  RateResponseDto toResponse(RateModel rateModel);

  List<RateResponseDto> toResponseList(List<RateModel> rateModelList);
}

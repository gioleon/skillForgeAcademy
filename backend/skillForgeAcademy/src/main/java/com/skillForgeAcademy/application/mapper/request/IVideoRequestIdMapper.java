package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.VideoRequestIdDto;
import com.skillForgeAcademy.domain.model.VideoModelId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IVideoRequestIdMapper {
  VideoModelId toModel(VideoRequestIdDto videoRequestIdDto);
}

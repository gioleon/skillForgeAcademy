package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.VideoRequestDto;
import com.skillForgeAcademy.domain.model.VideoModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IVideoRequestMapper {
  VideoModel toModel(VideoRequestDto videoRequestDto);
}

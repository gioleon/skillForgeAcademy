package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.VideoModelId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.VideoEntityId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IVideoEntityIdMapper {
  VideoEntityId toEntityId(VideoModelId videoModelId);
  VideoModelId toModelId(VideoEntityId videoEntityId);
}

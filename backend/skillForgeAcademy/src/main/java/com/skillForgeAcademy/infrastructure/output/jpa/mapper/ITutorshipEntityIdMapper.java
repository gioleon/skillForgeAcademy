package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntityId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ITutorshipEntityIdMapper {
  TutorshipEntityId toEntityId(TutorshipModelId tutorshipModelId);
  TutorshipModelId toModelId(TutorshipEntityId tutorshipEntityId);
}

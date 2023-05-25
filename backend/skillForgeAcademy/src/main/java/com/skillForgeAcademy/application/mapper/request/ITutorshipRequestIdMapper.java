package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.TutorshipRequestIdDto;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITutorshipRequestIdMapper {
  TutorshipModelId toModel(TutorshipRequestIdDto tutorshipRequestIdDto);
}

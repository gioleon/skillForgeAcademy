package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.TutorshipRequestDto;
import com.skillForgeAcademy.domain.model.TutorshipModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITutorshipRequestMapper {
  TutorshipModel toModel(TutorshipRequestDto tutorshipRequestDto);
}

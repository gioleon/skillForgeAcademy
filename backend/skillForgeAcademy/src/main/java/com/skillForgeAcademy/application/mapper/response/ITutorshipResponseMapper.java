package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.TutorshipResponseDto;
import com.skillForgeAcademy.domain.model.TutorshipModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITutorshipResponseMapper {
    TutorshipResponseDto toResponse(TutorshipModel tutorshipModel);
    List<TutorshipResponseDto> toResponseList(List<TutorshipModel> tutorshipList);
}

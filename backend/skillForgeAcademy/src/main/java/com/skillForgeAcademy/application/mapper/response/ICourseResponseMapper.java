package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.CourseResponseDto;
import com.skillForgeAcademy.domain.model.CourseModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICourseResponseMapper {
  CourseResponseDto toResponse(CourseModel courseModel);

  List<CourseResponseDto> toResponseList(List<CourseModel> courses);
}

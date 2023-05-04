package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.CourseModel;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CourseEntity;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICourseEntityMapper {
    CourseModel toModel(CourseEntity courseEntity);
    CourseEntity toEntity(CourseModel courseModel);
    List<CourseModel> toModelList(List<CourseEntity> courseEntities);
}

package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITutorshipEntityMapper {
    TutorshipModel toModel(TutorshipEntity tutorshipEntity);
    TutorshipEntity toEntity(TutorshipModel tutorshipModel);
    List<TutorshipModel> toModelList(List<TutorshipEntity> tutorshipEntities);
}

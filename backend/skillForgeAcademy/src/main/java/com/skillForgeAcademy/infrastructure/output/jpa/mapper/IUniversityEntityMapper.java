package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.UniversityModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UniversityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUniversityEntityMapper {
    UniversityModel toModel(UniversityEntity tutorshipEntity);
    UniversityEntity toEntity(UniversityModel tutorshipModel);
    List<UniversityModel> toModelList(List<UniversityEntity> tutorshipEntities);
}

package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RolEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRolEntityMapper {

    RolModel toModel(RolEntity rolEntity);
    RolEntity toEntity(RolModel rolModel);
    List<RolModel> toModelList(List<RolEntity> rolEntities);

}

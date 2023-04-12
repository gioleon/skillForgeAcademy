package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {

    UserModel toModel(UserEntity userEntity);
    UserEntity toEntity(UserModel userModel);
    List<UserModel> toModelList(List<UserEntity> userEntities);
    List<UserEntity> toEntityList(List<UserModel> userModels);

}

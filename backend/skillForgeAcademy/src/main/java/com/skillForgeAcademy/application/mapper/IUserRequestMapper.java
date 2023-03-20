package com.skillForgeAcademy.application.mapper;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    UserModel toModel(UserRequestDto userRequestDto);
}

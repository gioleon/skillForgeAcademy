package com.skillForgeAcademy.application.mapper;

import com.skillForgeAcademy.application.dto.response.UserResponseDto;
import com.skillForgeAcademy.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserResponseMapper {

    UserResponseDto toResponse(UserModel userModel);
    List<UserResponseDto> toResponseList(List<UserModel> userModels);

}

package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.UserResponseDto;
import com.skillForgeAcademy.application.handler.IUserHandler;
import com.skillForgeAcademy.application.mapper.request.IUserRequestMapper;
import com.skillForgeAcademy.application.mapper.response.IUserResponseMapper;
import com.skillForgeAcademy.domain.api.IUserServicePort;
import com.skillForgeAcademy.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserResponseMapper userResponseMapper;
    private final IUserRequestMapper userRequestMapper;


    @Override
    public void save(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toModel(userRequestDto);
        userServicePort.create(userModel);
    }

    @Override
    public UserResponseDto findById(Long id) {
        UserModel userModel = userServicePort.find(id);
        return userResponseMapper.toResponse(userModel);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList((List<UserModel>) userServicePort.findAll());
    }

    @Override
    public UserResponseDto findByEmail(String email) {
        return null;
    }

    @Override
    public void register(UserRequestDto userRequestDto) {
        userServicePort.register(userRequestMapper.toModel(userRequestDto));
    }

    @Override
    public void updateIsEnable(Long id) {
        userServicePort.updateIsEnable(id);
    }
}

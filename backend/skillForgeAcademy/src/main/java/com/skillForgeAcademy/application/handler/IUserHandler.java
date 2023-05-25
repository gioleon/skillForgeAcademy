package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.UserResponseDto;

import java.util.List;

public interface IUserHandler {

    void save(UserRequestDto userRequestDto);

    UserResponseDto findById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto findByEmail(String email);
    void register(UserRequestDto userRequestDto);
    void updateIsEnable(Long id);

    void activateAccount(String token);


}

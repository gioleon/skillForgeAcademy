package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.UniversityRequestDto;
import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.UniversityResponseDto;
import com.skillForgeAcademy.application.dto.response.UserResponseDto;

import java.util.List;

public interface IUniversityHandler {
    void save(UniversityRequestDto university);

    UniversityResponseDto findById(Long id);
    List<UniversityResponseDto> getAllUniversities();
}

package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.UniversityRequestDto;
import com.skillForgeAcademy.application.dto.response.UniversityResponseDto;
import com.skillForgeAcademy.application.handler.IUniversityHandler;
import com.skillForgeAcademy.application.mapper.request.IUniversityRequestMapper;
import com.skillForgeAcademy.application.mapper.response.IUniversityResponseMapper;
import com.skillForgeAcademy.domain.api.IUniversityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UniversityHandlerImpl implements IUniversityHandler {

    private final IUniversityRequestMapper universityRequestMapper;
    private final IUniversityResponseMapper universityResponseMapper;
    private final IUniversityServicePort universityServicePort;

    @Override
    public void save(UniversityRequestDto university) {
        universityServicePort.create(universityRequestMapper.toModel(university));
    }

    @Override
    public UniversityResponseDto findById(Long id) {
        return universityResponseMapper.toResponse(universityServicePort.find(id));
    }

    @Override
    public List<UniversityResponseDto> getAllUniversities() {
        return universityResponseMapper.toResponseList(universityServicePort.findAll());
    }
}

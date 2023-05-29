package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.SectionRequestDto;
import com.skillForgeAcademy.application.dto.request.SectionRequestIdDto;
import com.skillForgeAcademy.application.dto.response.SectionResponseDto;
import com.skillForgeAcademy.application.handler.ISectionHandler;
import com.skillForgeAcademy.application.mapper.request.ISectionRequestIdMapper;
import com.skillForgeAcademy.application.mapper.request.ISectionRequestMapper;
import com.skillForgeAcademy.application.mapper.response.ISectionResponseMapper;
import com.skillForgeAcademy.domain.api.ISectionServicePort;
import com.skillForgeAcademy.domain.model.SectionModel;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class SectionHandlerImpl implements ISectionHandler {
  private final ISectionServicePort sectionServicePort;
  private final ISectionResponseMapper sectionResponseMapper;
  private final ISectionRequestMapper sectionRequestMapper;
  private final ISectionRequestIdMapper sectionRequestIdMapper;

  @Override
  public SectionResponseDto create(SectionRequestDto sectionRequestDto) {
    SectionModel sectionModel = sectionRequestMapper.toModel(sectionRequestDto);
    return sectionResponseMapper.toResponse(sectionServicePort.create(sectionModel));
  }

  @Override
  public SectionResponseDto find(SectionRequestIdDto sectionRequestIdDto) {
    SectionModel sectionModel =
        sectionServicePort.find(sectionRequestIdMapper.toModel(sectionRequestIdDto));
    return sectionResponseMapper.toResponse(sectionModel);
  }

  @Override
  public SectionResponseDto delete(SectionRequestIdDto sectionRequestIdDto) {
    SectionModel sectionModel =
        sectionServicePort.delete(sectionRequestIdMapper.toModel(sectionRequestIdDto));
    return sectionResponseMapper.toResponse(sectionModel);
  }

  @Override
  public List<SectionResponseDto> findAll() {
    return sectionResponseMapper.toResponseList(sectionServicePort.findAll());
  }
}

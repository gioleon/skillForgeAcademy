package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.TutorshipRequestDto;
import com.skillForgeAcademy.application.dto.request.TutorshipRequestIdDto;
import com.skillForgeAcademy.application.dto.response.TutorshipResponseDto;
import com.skillForgeAcademy.application.handler.ITutorshipHandler;
import com.skillForgeAcademy.application.mapper.request.ITutorshipRequestIdMapper;
import com.skillForgeAcademy.application.mapper.request.ITutorshipRequestMapper;
import com.skillForgeAcademy.application.mapper.response.ITutorshipResponseMapper;
import com.skillForgeAcademy.domain.api.ITutorshipServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class TutorshipHandlerImpl implements ITutorshipHandler {
  private final ITutorshipServicePort tutorshipServicePort;
  private final ITutorshipRequestMapper tutorshipRequestMapper;
  private final ITutorshipRequestIdMapper tutorshipRequestIdMapper;
  private final ITutorshipResponseMapper tutorshipResponseMapper;

  @Override
  public void create(TutorshipRequestDto tutorshipRequestDto) {
    tutorshipServicePort.create(tutorshipRequestMapper.toModel(tutorshipRequestDto));
  }

  @Override
  public TutorshipResponseDto find(TutorshipRequestIdDto tutorshipRequestIdDto) {
    return tutorshipResponseMapper.toResponse(
        tutorshipServicePort.find(tutorshipRequestIdMapper.toModel(tutorshipRequestIdDto)));
  }

  @Override
  public TutorshipResponseDto delete(TutorshipRequestIdDto tutorshipRequestIdDto) {
    return tutorshipResponseMapper.toResponse(
        tutorshipServicePort.delete(tutorshipRequestIdMapper.toModel(tutorshipRequestIdDto)));
  }

  @Override
  public List<TutorshipResponseDto> findAll() {
    return tutorshipResponseMapper.toResponseList(tutorshipServicePort.findAll());
  }
}

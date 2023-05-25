package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.TutorshipRequestDto;
import com.skillForgeAcademy.application.dto.request.TutorshipRequestIdDto;
import com.skillForgeAcademy.application.dto.response.TutorshipResponseDto;
import java.util.List;

public interface ITutorshipHandler {
  void create(TutorshipRequestDto tutorshipRequestDto);

  TutorshipResponseDto find(TutorshipRequestIdDto tutorshipRequestIdDto);

  TutorshipResponseDto delete(TutorshipRequestIdDto tutorshipRequestIdDto);

  List<TutorshipResponseDto> findAll();
}

package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.SectionRequestDto;
import com.skillForgeAcademy.application.dto.request.SectionRequestIdDto;
import com.skillForgeAcademy.application.dto.response.SectionResponseDto;
import java.util.List;

public interface ISectionHandler {
  SectionResponseDto create(SectionRequestDto sectionRequestDto);

  SectionResponseDto find(SectionRequestIdDto sectionRequestIdDto);

  SectionResponseDto delete(SectionRequestIdDto sectionRequestIdDto);

  List<SectionResponseDto> findAll();
}

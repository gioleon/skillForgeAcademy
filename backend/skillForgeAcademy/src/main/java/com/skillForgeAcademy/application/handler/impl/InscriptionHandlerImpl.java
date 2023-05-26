package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.InscriptionRequestDto;
import com.skillForgeAcademy.application.dto.response.InscriptionResponseDto;
import com.skillForgeAcademy.application.handler.IInscriptionHandler;
import com.skillForgeAcademy.application.mapper.request.IInscriptionRequestMapper;
import com.skillForgeAcademy.application.mapper.response.IInscriptionResponseMapper;
import com.skillForgeAcademy.domain.api.IInscriptionServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InscriptionHandlerImpl implements IInscriptionHandler {

  private final IInscriptionServicePort inscriptionServicePort;
  private final IInscriptionRequestMapper inscriptionRequestMapper;
  private final IInscriptionResponseMapper inscriptionResponseMapper;

  @Override
  public void create(InscriptionRequestDto inscriptionRequestDto) {
    inscriptionServicePort.create(inscriptionRequestMapper.toModel(inscriptionRequestDto));
  }

  @Override
  public List<InscriptionResponseDto> findByStudent(Long idUser) {
    return inscriptionResponseMapper.toResponseList(inscriptionServicePort.findByStudent(idUser));
  }
}

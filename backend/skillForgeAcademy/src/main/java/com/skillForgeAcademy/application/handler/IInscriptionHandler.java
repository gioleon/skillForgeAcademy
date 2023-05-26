package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.InscriptionRequestDto;
import com.skillForgeAcademy.application.dto.response.InscriptionResponseDto;
import java.util.List;

public interface IInscriptionHandler {
  void create(InscriptionRequestDto inscriptionRequestDto);

  List<InscriptionResponseDto> findByStudent(Long idUser);
}

package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.InscriptionRequestDto;
import com.skillForgeAcademy.application.dto.response.InscriptionResponseDto;
import com.skillForgeAcademy.application.handler.IInscriptionHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscription")
@RequiredArgsConstructor
public class InscriptionRestController {

  private final IInscriptionHandler inscriptionHandler;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody InscriptionRequestDto inscriptionRequestDto) {
    inscriptionHandler.create(inscriptionRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/student/{idUser}")
  public ResponseEntity<List<InscriptionResponseDto>> findByStudent(@PathVariable Long idUser) {
    return ResponseEntity.ok(inscriptionHandler.findByStudent(idUser));
  }
}

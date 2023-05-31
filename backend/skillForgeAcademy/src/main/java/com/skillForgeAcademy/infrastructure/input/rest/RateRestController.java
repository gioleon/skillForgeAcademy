package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.request.RateRequestDto;
import com.skillForgeAcademy.application.dto.request.RateRequestIdDto;
import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.RateResponseDto;
import com.skillForgeAcademy.application.handler.IRateHandler;
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
@RequestMapping("/api/rate")
@RequiredArgsConstructor
public class RateRestController {
  private final IRateHandler rateHandler;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody RateRequestDto rateRequestDto) {
    rateHandler.create(rateRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<RateResponseDto>> findAll() {
    return ResponseEntity.ok(rateHandler.findAll());
  }

  @GetMapping("/{idUser}/{idCourse}")
  public ResponseEntity<RateResponseDto> findById(
      @PathVariable Long idUser, @PathVariable Long idCourse) {

    RateRequestIdDto rateRequestIdDto = new RateRequestIdDto();
    CourseRequestDto courseRequestDto = new CourseRequestDto();
    UserRequestDto userRequestDto = new UserRequestDto();

    courseRequestDto.setId(idCourse);
    userRequestDto.setId(idUser);

    rateRequestIdDto.setCourse(courseRequestDto);
    rateRequestIdDto.setUser(userRequestDto);

    return ResponseEntity.ok(rateHandler.find(rateRequestIdDto));
  }

  @GetMapping("course/{idCourse}")
  public ResponseEntity<List<RateResponseDto>> findByCourse(@PathVariable Long idCourse) {
    return ResponseEntity.ok(rateHandler.findByCourse(idCourse));
  }
}

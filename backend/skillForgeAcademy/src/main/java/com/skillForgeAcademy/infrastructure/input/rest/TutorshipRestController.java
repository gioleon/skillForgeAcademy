package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.request.SectionRequestDto;
import com.skillForgeAcademy.application.dto.request.TutorshipRequestDto;
import com.skillForgeAcademy.application.dto.request.TutorshipRequestIdDto;
import com.skillForgeAcademy.application.dto.response.TutorshipResponseDto;
import com.skillForgeAcademy.application.handler.ITutorshipHandler;
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
@RequestMapping("/api/tutorship")
@RequiredArgsConstructor
public class TutorshipRestController {
  private final ITutorshipHandler tutorshipHandler;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody TutorshipRequestDto tutorshipRequestDto) {
    tutorshipHandler.create(tutorshipRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<TutorshipResponseDto>> findAll() {
    return ResponseEntity.ok(tutorshipHandler.findAll());
  }

  @GetMapping("/{idCourse}/{idSection}/{idTutorship}")
  public ResponseEntity<TutorshipResponseDto> findById(
      @PathVariable Long idCourse, @PathVariable Long idSection, @PathVariable Long idTutorship) {

    CourseRequestDto courseRequest = new CourseRequestDto();
    SectionRequestDto sectionRequestDto = new SectionRequestDto();
    TutorshipRequestIdDto tutorshipRequestIdDto = new TutorshipRequestIdDto();

    courseRequest.setId(idCourse);
    sectionRequestDto.setId(idSection);
    sectionRequestDto.setCourse(courseRequest);

    tutorshipRequestIdDto.setSection(sectionRequestDto);
    tutorshipRequestIdDto.setCourse(courseRequest);
    tutorshipRequestIdDto.setId(idTutorship);

    return ResponseEntity.ok(tutorshipHandler.find(tutorshipRequestIdDto));
  }

  @GetMapping("/delete/{idCourse}/{idSection}/{idTutorship}")
  public ResponseEntity<TutorshipResponseDto> deleteById(
      @PathVariable Long idCourse, @PathVariable Long idSection, @PathVariable Long idTutorship) {

    CourseRequestDto courseRequest = new CourseRequestDto();
    SectionRequestDto sectionRequestDto = new SectionRequestDto();
    TutorshipRequestIdDto tutorshipRequestIdDto = new TutorshipRequestIdDto();

    courseRequest.setId(idCourse);
    sectionRequestDto.setId(idSection);
    sectionRequestDto.setCourse(courseRequest);

    tutorshipRequestIdDto.setSection(sectionRequestDto);
    tutorshipRequestIdDto.setCourse(courseRequest);
    tutorshipRequestIdDto.setId(idTutorship);

    return ResponseEntity.ok(tutorshipHandler.delete(tutorshipRequestIdDto));
  }

  @GetMapping("course/{idCourse}")
  public ResponseEntity<List<TutorshipResponseDto>> findByCourse(@PathVariable Long idCourse) {
    return ResponseEntity.ok(tutorshipHandler.findByCourse(idCourse));
  }
}

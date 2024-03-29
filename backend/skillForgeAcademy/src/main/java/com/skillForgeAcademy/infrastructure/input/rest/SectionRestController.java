package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.request.SectionRequestDto;
import com.skillForgeAcademy.application.dto.request.SectionRequestIdDto;
import com.skillForgeAcademy.application.dto.response.CourseResponseDto;
import com.skillForgeAcademy.application.dto.response.SectionResponseDto;
import com.skillForgeAcademy.application.handler.ISectionHandler;
import java.net.URI;
import java.net.URISyntaxException;import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/section")
@RequiredArgsConstructor
public class SectionRestController {

  private final ISectionHandler sectionHandler;

  @PostMapping
  public ResponseEntity<SectionResponseDto> create(
      @RequestBody SectionRequestDto sectionRequestDto)throws URISyntaxException {
    SectionResponseDto sectionResponseDto = sectionHandler.create(sectionRequestDto);
    return ResponseEntity.created(
            new URI("http://localhost:8080/section/" + sectionResponseDto.getId()))
        .body(sectionResponseDto);
  }

  @GetMapping("/all")
  public ResponseEntity<List<SectionResponseDto>> findAll() {
    return ResponseEntity.ok(sectionHandler.findAll());
  }

  @GetMapping("/{idCourse}/{idSection}")
  public ResponseEntity<SectionResponseDto> findById(
      @PathVariable Long idCourse, @PathVariable Long idSection) {
    CourseRequestDto courseRequestDto = new CourseRequestDto();
    SectionRequestIdDto sectionRequestIdDto = new SectionRequestIdDto();

    courseRequestDto.setId(idCourse);
    sectionRequestIdDto.setId(idSection);
    sectionRequestIdDto.setCourse(courseRequestDto);

    return ResponseEntity.ok(sectionHandler.find(sectionRequestIdDto));
  }

  @GetMapping("/delete/{idCourse}/{idSection}")
  public ResponseEntity<SectionResponseDto> deleteById(
      @PathVariable Long idCourse, @PathVariable Long idSection) {
    CourseResponseDto courseResponseDto = new CourseResponseDto();
    SectionRequestIdDto sectionRequestIdDto = new SectionRequestIdDto();

    courseResponseDto.setId(idCourse);
    sectionRequestIdDto.setId(idSection);

    return ResponseEntity.ok(sectionHandler.delete(sectionRequestIdDto));
  }
}

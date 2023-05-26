package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.response.CourseResponseDto;
import com.skillForgeAcademy.application.handler.ICourseHandler;
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
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseRestController {
  private final ICourseHandler courseHandler;

  @PostMapping()
  public ResponseEntity<Void> create(@RequestBody CourseRequestDto courseRequestDto) {
    courseHandler.create(courseRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<CourseResponseDto>> findAll() {
    return ResponseEntity.ok(courseHandler.getAllCourses());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseResponseDto> find(@PathVariable Long id) {
    return ResponseEntity.ok(courseHandler.find(id));
  }

  @GetMapping("/delete/{id}")
  public ResponseEntity<CourseResponseDto> delete(@PathVariable Long id) {
    return ResponseEntity.ok(courseHandler.delete(id));
  }

  @GetMapping("/owner/{idOwner}")
  public ResponseEntity<List<CourseResponseDto>> findByOwner(@PathVariable Long idOwner) {
    return ResponseEntity.ok(courseHandler.findByOwner(idOwner));
  }
}

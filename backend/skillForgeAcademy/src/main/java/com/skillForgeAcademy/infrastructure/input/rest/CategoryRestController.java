package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.CategoryRequestDto;
import com.skillForgeAcademy.application.dto.response.CategoryResponseDto;
import com.skillForgeAcademy.application.handler.ICategoryHandler;
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
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryRestController {
  private final ICategoryHandler categoryHandler;

  @PostMapping()
  public ResponseEntity<Void> create(@RequestBody CategoryRequestDto categoryRequestDto) {
    categoryHandler.create(categoryRequestDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/all")
  public ResponseEntity<List<CategoryResponseDto>> findAll() {
    return ResponseEntity.ok(categoryHandler.getAllCategories());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponseDto> find(@PathVariable Long id) {
    return ResponseEntity.ok(categoryHandler.find(id));
  }

  @GetMapping("/delete/{id}")
  public ResponseEntity<CategoryResponseDto> delete(@PathVariable Long id) {
    return ResponseEntity.ok(categoryHandler.delete(id));
  }
}

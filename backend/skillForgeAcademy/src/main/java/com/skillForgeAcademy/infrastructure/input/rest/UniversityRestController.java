package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.UniversityRequestDto;
import com.skillForgeAcademy.application.dto.response.UniversityResponseDto;
import com.skillForgeAcademy.application.handler.IUniversityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityRestController {
    private final IUniversityHandler universityHandler;

    @GetMapping("/{id}")
    public ResponseEntity<UniversityResponseDto> findUniversity(@PathVariable Long id) {
        return ResponseEntity.ok(universityHandler.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createUniversity(
            @RequestBody UniversityRequestDto universityRequestDto) {
        universityHandler.save(universityRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UniversityResponseDto>> findAll() {
        return ResponseEntity.ok(universityHandler.getAllUniversities());
    }

}

package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.UserResponseDto;
import com.skillForgeAcademy.application.handler.IUserHandler;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {

  private final IUserHandler userHandler;

  @PostMapping("/create")
  public ResponseEntity<Void> create(@RequestBody UserRequestDto user) {
    userHandler.save(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<UserResponseDto>> findAll() {
    return ResponseEntity.ok(this.userHandler.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDto> find(@PathVariable long id) {
    return ResponseEntity.ok(this.userHandler.findById(id));
  }
}

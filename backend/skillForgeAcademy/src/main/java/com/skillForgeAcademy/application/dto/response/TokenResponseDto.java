package com.skillForgeAcademy.application.dto.response;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponseDto {
  private long id;
  private String token;
  private LocalDateTime createdAt;
  private LocalDateTime expiredAt;
  private LocalDateTime confirmedAt;
  private UserResponseDto user;
}

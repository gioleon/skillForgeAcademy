package com.skillForgeAcademy.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenActivationModel {

  private long id;
  private String token;
  private LocalDateTime createdAt;
  private LocalDateTime expiredAt;
  private LocalDateTime confirmedAt;
  private long userId;

  public TokenActivationModel(String token, Long userId) {
    this.token = token;
    this.createdAt = LocalDateTime.now();
    this.expiredAt = LocalDateTime.now().plusHours(24);
    this.userId = userId;
  }
}

package com.skillForgeAcademy.application.dto.response;

import com.skillForgeAcademy.domain.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TokenResponseDto {
    private long id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    private UserModel user;
}

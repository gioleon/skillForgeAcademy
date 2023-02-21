package com.skillForgeAcademy.models.token.domain.model;


import com.skillForgeAcademy.models.token.infrastructure.database.entity.TokenEntity;
import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.infrastructure.database.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    private long id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    private User user;

    public Token(
            String token, LocalDateTime createdAt,
            LocalDateTime expiredAt, User user){
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.user = user;
    }

    public TokenEntity toTokenEntity(){
        return TokenEntity.builder()
                .id(this.id)
                .token(this.token)
                .createdAt(this.createdAt)
                .expiredAt(this.expiredAt)
                .confirmedAt(this.confirmedAt)
                .userEntity(this.user.toUserEntity())
                .build();
    }
}

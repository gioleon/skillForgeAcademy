package com.skillForgeAcademy.infrastructure.output.jpa.entity;


import com.skillForgeAcademy.domain.model.TokenModel;
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
@Entity
@Table(name = "tokens")
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;

    @OneToOne()
    private UserEntity userEntity;

    public TokenEntity(
            String token, LocalDateTime createdAt,
            LocalDateTime expiredAt, UserEntity userEntity){
        this.token = token;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.userEntity = userEntity;
    }

    public TokenModel toToken(){
        return TokenModel.builder()
                .id(this.id)
                .token(this.token)
                .createdAt(this.createdAt)
                .expiredAt(this.expiredAt)
                .confirmedAt(this.confirmedAt)
                .user(this.userEntity.toUser())
                .build();
    }
}
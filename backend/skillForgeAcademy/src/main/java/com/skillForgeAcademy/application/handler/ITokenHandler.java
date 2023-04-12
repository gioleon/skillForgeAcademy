package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.response.TokenResponseDto;

public interface ITokenHandler {

    TokenResponseDto find(String token);
    void confirmToken(String token);

}

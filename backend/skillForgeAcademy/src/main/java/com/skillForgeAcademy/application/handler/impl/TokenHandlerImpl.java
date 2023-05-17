package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.response.TokenResponseDto;
import com.skillForgeAcademy.application.handler.ITokenHandler;
import com.skillForgeAcademy.application.mapper.response.ITokenResponseMapper;
import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.model.TokenModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenHandlerImpl implements ITokenHandler {

    private final ITokenServicePort tokenServicePort;
    private final ITokenResponseMapper tokenResponseMapper;

    @Override
    public TokenResponseDto find(String token) {
        TokenModel tokenModel = tokenServicePort.findByToken(token);
        return tokenResponseMapper.toResponse(tokenModel);
    }

    @Override
    public void confirmToken(String token) {
        tokenServicePort.confirmToken(token);
    }
}

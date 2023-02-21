package com.skillForgeAcademy.models.token.application.ports.output;

import com.skillForgeAcademy.models.token.domain.model.Token;
import com.skillForgeAcademy.models.token.infrastructure.database.entity.TokenEntity;
import com.skillForgeAcademy.utilities.GenericService;

public interface TokenService extends GenericService<Token, String> {
    boolean confirmToken(String token) throws Exception;
}

package com.skillForgeAcademy.models.token.domain.ports.input;

import com.skillForgeAcademy.models.token.domain.model.Token;
import com.skillForgeAcademy.utilities.GenericService;

public interface TokenServicePort extends GenericService<Token, String> {
    boolean confirmToken(String token) throws Exception;
}

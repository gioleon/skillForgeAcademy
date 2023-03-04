package com.skillForgeAcademy.models.token.domain.ports.output;

import com.skillForgeAcademy.models.token.domain.model.Token;
import com.skillForgeAcademy.utilities.GenericService;

public interface TokenPersistencePort extends GenericService<Token, String> {
    boolean confirmToken(String token) throws Exception;

}

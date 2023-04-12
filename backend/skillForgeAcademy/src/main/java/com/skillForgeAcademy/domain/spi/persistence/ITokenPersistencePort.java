package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ITokenPersistencePort extends GenericService<TokenModel, String> {
    void confirmToken(String token);
    TokenModel findByToken(String token);

}

package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ITokenServicePort extends GenericService<TokenModel, String> {
    void confirmToken(String token);
    TokenModel findByToken(String token);
}

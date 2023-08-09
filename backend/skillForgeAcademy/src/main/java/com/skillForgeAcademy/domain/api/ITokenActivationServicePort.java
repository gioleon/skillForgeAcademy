package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.TokenActivationModel;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ITokenActivationServicePort extends GenericService<TokenActivationModel, String> {
    void confirmToken(String token);
    TokenActivationModel findByToken(String token);
}

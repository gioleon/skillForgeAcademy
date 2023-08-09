package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.TokenActivationModel;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ITokenActivationPersistencePort extends GenericService<TokenActivationModel, String> {
    void confirmToken(String token);
    TokenActivationModel findByToken(String token);

}

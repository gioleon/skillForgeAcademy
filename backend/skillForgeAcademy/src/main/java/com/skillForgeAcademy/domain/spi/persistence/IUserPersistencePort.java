package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface IUserPersistencePort extends GenericService<UserModel, Long> {

    UserModel findByEmail(String email);

    int updateIsEnable(long userId);
}
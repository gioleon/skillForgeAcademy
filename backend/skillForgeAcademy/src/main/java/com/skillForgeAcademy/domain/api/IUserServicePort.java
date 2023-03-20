package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface IUserServicePort extends GenericService<UserModel, Long> {

    UserModel findByEmail(String email);

    int updateIsEnable(long userId);

    void register(UserModel userModel);

}

package com.skillForgeAcademy.models.user.domain.ports.input;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.utilities.GenericService;

public interface UserServicePort extends GenericService<User, Long> {

    User findByEmail(String email);

    int updateIsEnable(long userId);
}

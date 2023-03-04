package com.skillForgeAcademy.models.user.domain.ports.output;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.utilities.GenericService;

public interface UserPersistencePort extends GenericService<User, Long> {

    User findByEmail(String email);

    int updateIsEnable(long userId);
}
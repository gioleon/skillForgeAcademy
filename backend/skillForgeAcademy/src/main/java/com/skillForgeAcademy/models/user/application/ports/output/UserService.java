package com.skillForgeAcademy.models.user.application.ports.output;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.utilities.GenericService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends GenericService<User, Long> {

    User findByEmail(String email);

    int updateIsEnable(long userId);
}

package com.skillForgeAcademy.user.application.ports.output;

import com.skillForgeAcademy.user.domain.model.User;
import com.skillForgeAcademy.utilities.GenericService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends GenericService<User, Long> {
}

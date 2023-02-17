package com.noname.user.application.ports.output;

import com.noname.user.domain.model.User;
import com.noname.utilities.GenericService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends GenericService<User, Long> {
}

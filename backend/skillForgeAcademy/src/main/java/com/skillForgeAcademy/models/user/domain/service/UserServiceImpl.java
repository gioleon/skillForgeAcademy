package com.skillForgeAcademy.models.user.domain.service;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.domain.ports.input.UserServicePort;
import com.skillForgeAcademy.models.user.domain.ports.output.UserPersistencePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserServicePort {

    UserPersistencePort userPersistencePort;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User findByEmail(String email) {
        return this.userPersistencePort.findByEmail(email);
    }

    @Override
    public int updateIsEnable(long userId) {
        return this.userPersistencePort.updateIsEnable(userId);
    }

    @Override
    public User create(User user) {
        final String encodedPassword = this.passwordEncoder.encode(user.getPassword());

        // set password to the user
        user.setPassword(encodedPassword);
        return this.userPersistencePort.create(user);
    }

    @Override
    public User find(Long id) {
        return this.userPersistencePort.find(id);
    }

    @Override
    public Iterable<User> findAll() {
        return this.userPersistencePort.findAll();
    }

    @Override
    public User delete(Long id) throws Exception {
        return this.userPersistencePort.delete(id);
    }
}

package com.skillForgeAcademy.models.user.infrastructure.database.service;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.application.ports.output.UserService;
import com.skillForgeAcademy.models.user.infrastructure.database.entity.UserEntity;
import com.skillForgeAcademy.models.user.infrastructure.database.repository.PostgresUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserEntityServiceImpl implements UserService {
    /*
     * As probably we are going to implement more functionality,
     * lets use autowired directly.
     */

    private PostgresUserEntityRepository repository;
    private BCryptPasswordEncoder passwordEncoder;

    UserEntityServiceImpl(
            PostgresUserEntityRepository repository,
            BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        // Encoding password
        final String encodedPassword = this.passwordEncoder.encode(user.getPassword());

        // set password to the user
        user.setPassword(encodedPassword);

        // saving user
        return this.repository.save(user.toUserEntity()).toUser();
    }

    @Override
    public User find(Long aLong) {
        Optional<UserEntity> userEntity = this.repository.findById(aLong);
        return !userEntity.isEmpty() ? userEntity.get().toUser() : null;
    }

    @Override
    public Iterable<User> findAll() {

        List<User> listUser = (List<User>)
                ((List<UserEntity>) this.repository.findAll())
                        .stream()
                        .map(userEntity -> userEntity.toUser())
                        .collect(Collectors.toList());

        return listUser;
    }

    @Override
    public User delete(Long id) throws Exception {
        User user = this.find(id);
        if (user == null) {
            throw new Exception("User not exists.");
        }
        this.repository.deleteById(id);

        return user;
    }

    @Override
    public User findByEmail(String email) {
        Optional<UserEntity> user = this.repository.findByEmail(email);

        if (user.isEmpty()){
            throw new UsernameNotFoundException("NO USER FOUND");
        }

        return user.get().toUser();
    }
}

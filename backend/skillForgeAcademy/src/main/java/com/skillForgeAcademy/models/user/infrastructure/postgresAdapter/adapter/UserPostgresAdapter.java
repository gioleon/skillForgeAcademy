package com.skillForgeAcademy.models.user.infrastructure.postgresAdapter.adapter;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.domain.ports.input.UserServicePort;
import com.skillForgeAcademy.models.user.domain.ports.output.UserPersistencePort;
import com.skillForgeAcademy.models.user.infrastructure.postgresAdapter.entity.UserEntity;
import com.skillForgeAcademy.models.user.infrastructure.postgresAdapter.repository.PostgresUserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class UserPostgresAdapter implements UserPersistencePort {
    /*
     * As probably we are going to implement more functionality,
     * lets use autowired directly.
     */

    @Autowired
    private PostgresUserEntityRepository repository;

    @Override
    public User create(User user) {
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

        List<User> listUser =
                ((List<UserEntity>) this.repository.findAll())
                        .stream()
                        .map(UserEntity::toUser)
                        .collect(Collectors.toList());

        return listUser;
    }

    @Override
    public User delete(Long id) throws Exception {
        User user = this.find(id);
        if (user == null) {
            log.warn("ERROR! USER NOT FOUND: {}", user.getId());
            throw new Exception("USER NOT EXISTS.");
        }
        this.repository.deleteById(id);

        return user;
    }

    @Override
    public User findByEmail(String email) {
        Optional<UserEntity> user = this.repository.findByEmail(email);

        if (user.isEmpty()){

            return null;
        }

        return user.get().toUser();
    }

    @Override
    public int updateIsEnable(long userId) {
        // change isEnable status to true
        return this.repository.updateIsEnable(userId);
    }
}

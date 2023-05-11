package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.spi.persistence.IUserPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    /*
     * As probably we are going to implement more functionality,
     * lets use autowired directly.
     */

    private final IUserRepository repository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public UserModel create(UserModel user) {
        UserEntity userEntity = repository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toModel(userEntity);
    }

    @Override
    public UserModel find(Long aLong) {
        Optional<UserEntity> userEntity = this.repository.findById(aLong);
        if (userEntity.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return userEntityMapper.toModel(userEntity.get());
    }

    @Override
    public List<UserModel> findAll() {
        List<UserEntity> userEntities = (List<UserEntity>) repository.findAll();
        if (userEntities.isEmpty()){
            throw new NoDataFoundException("NO DATA FOUND");
        }
        return userEntityMapper.toModelList(userEntities);
    }

    @Override
    public UserModel delete(Long id) {
        Optional<UserEntity> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new NoDataFoundException("NO DATA FOUND");
        }
        this.repository.deleteById(id);

        return userEntityMapper.toModel(user.get());
    }

    @Override
    public UserModel findByEmail(String email) {
        Optional<UserEntity> user = this.repository.findByEmail(email);
        if (user.isEmpty()){
            return null;
        }
        return userEntityMapper.toModel(user.get());
    }

    @Override
    public int updateIsEnable(long userId) {
        // change isEnable status to true
        return this.repository.updateIsEnable(userId);
    }
}

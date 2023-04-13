package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.exception.DomainException;
import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.api.IUserServicePort;
import com.skillForgeAcademy.domain.spi.passwordencoder.IPasswordEncoderPort;
import com.skillForgeAcademy.domain.spi.persistence.IUserPersistencePort;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class UserUseCase implements IUserServicePort {

    private IUserPersistencePort userPersistencePort;
    private ITokenServicePort tokenServicePort;
    private IPasswordEncoderPort passwordEncoder;

    public UserUseCase(IUserPersistencePort userPersistencePort,
                       ITokenServicePort tokenServicePort,
                       IPasswordEncoderPort passwordEncoderPort) {
        this.userPersistencePort = userPersistencePort;
        this.tokenServicePort = tokenServicePort;
        this.passwordEncoder = passwordEncoderPort;
    }

    @Override
    public UserModel findByEmail(String email) {
        return this.userPersistencePort.findByEmail(email);
    }

    @Override
    public int updateIsEnable(long userId) {
        return this.userPersistencePort.updateIsEnable(userId);
    }

    @Override
    public void register(UserModel userModel) {
        UserModel userFound = this.userPersistencePort.findByEmail(userModel.getEmail());
        if (userFound != null) {
            throw new DomainException("THERE'S ALREADY AN USER WITH THE GIVEN EMAIL: "
            + userModel.getEmail());
        }

        // if user not exists, setting user and create verification token
        userModel.setRoles(Arrays.asList(new RolModel(1, "ROLE_USER")));

        // save user
        this.userPersistencePort.create(userModel);

        TokenModel token = new TokenModel(
                UUID.randomUUID().toString(),
                this.userPersistencePort.findByEmail(userModel.getEmail()));

        // save token
        this.tokenServicePort.create(token);

        // sending email
        String activeURL = "http://localhost:8080/api/register/active?token=" + token.getToken();

        // sender.send("register.token", activeURL);
    }

    @Override
    public void activeAccount(String token) {
        TokenModel tokenFound = this.tokenServicePort.find(token);
        // set a confirmedAt value
        this.tokenServicePort.confirmToken(token);
        // change isEnable status to true
        this.userPersistencePort.updateIsEnable(tokenFound.getUser().getId());
    }

    @Override
    public UserModel create(UserModel user) {
        final String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        // set password to the user
        user.setPassword(encodedPassword);
        return this.userPersistencePort.create(user);
    }

    @Override
    public UserModel find(Long id) {
        return this.userPersistencePort.find(id);
    }

    @Override
    public List<UserModel> findAll() {
        return this.userPersistencePort.findAll();
    }

    @Override
    public UserModel delete(Long id) {
        return this.userPersistencePort.delete(id);
    }
}

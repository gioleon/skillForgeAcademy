package com.skillForgeAcademy.components.register.rest;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.token.domain.model.Token;
import com.skillForgeAcademy.models.token.domain.ports.input.TokenServicePort;
import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.domain.ports.input.UserServicePort;
import com.skillForgeAcademy.models.user.domain.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private UserServicePort userRepository;
    @Autowired
    private TokenServicePort tokenRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private StreamBridge sender;

    @PostMapping
    public ResponseEntity<HttpStatus> register(@RequestBody User user) throws Exception {

        // check if user exists
        User userFound = this.userRepository.findByEmail(user.getEmail());
        if (userFound != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        // if user not exists, setting user and create verification token
        user.setRoles(Arrays.asList(new Rol(1, "ROLE_USER")));

        // save user
        this.userRepository.create(user);

        Token token = new Token(
                UUID.randomUUID().toString(),
                this.userRepository.findByEmail(user.getEmail()));

        // save token
        this.tokenRepository.create(token);

        // sending email
        String activeURL = "http://localhost:8080/api/register/active?token=" + token.getToken();

        // sender.send("register.token", activeURL);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/active")
    public ResponseEntity<HttpStatus> activateAccount(@RequestParam() String token) throws Exception{
        Token tokenFound = this.tokenRepository.find(token);

        // set a confirmedAt value
        this.tokenRepository.confirmToken(token);
        // change isEnable status to true
        this.userRepository.updateIsEnable(tokenFound.getUser().getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

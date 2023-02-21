package com.skillForgeAcademy.components.signup.rest;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.user.application.ports.output.UserService;
import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.infrastructure.database.service.UserEntityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

    private UserService repository;
    private BCryptPasswordEncoder passwordEncoder;

    SignUpController(UserEntityServiceImpl repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<User> signup(@RequestBody User user) throws Exception {

        User userFound = this.repository.findByEmail(user.getEmail());



        if (userFound != null) {
            return new ResponseEntity<>(userFound, HttpStatus.BAD_REQUEST);
        }

        // Setting ROL_USER to this user
        user.setRoles(Arrays.asList(new Rol(1, "ROLE_USER")));

        return new ResponseEntity<>(this.repository.create(user), HttpStatus.CREATED);
    }

}

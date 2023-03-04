package com.skillForgeAcademy.models.user.application.rest;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.domain.ports.input.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServicePort repository;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(this.repository.create(user), HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<Iterable<User>> findAll(){
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }
}

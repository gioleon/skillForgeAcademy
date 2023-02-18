package com.skillForgeAcademy.user.infrastructure.rest;

import com.skillForgeAcademy.user.application.ports.output.UserService;
import com.skillForgeAcademy.user.domain.model.User;
import com.skillForgeAcademy.user.infrastructure.database.service.UserEntityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService repository;

    UserController(UserEntityServiceImpl repository){
        this.repository = repository;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(this.repository.create(user), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<User>> findAll(){
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }
}

package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.handler.IUserHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterRestController {

    private final IUserHandler userHandler;

    @PostMapping()
    public ResponseEntity<HttpStatus> register(@RequestBody UserRequestDto user) {
        userHandler.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/active")
    public ResponseEntity<HttpStatus> activateAccount(@RequestParam() String token){


        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.TokenResponseDto;
import com.skillForgeAcademy.application.handler.ITokenHandler;
import com.skillForgeAcademy.application.handler.IUserHandler;
import com.skillForgeAcademy.domain.model.TokenModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterRestController {

    private final IUserHandler userHandler;

    private final ITokenHandler tokenHandler;

    private final BCryptPasswordEncoder passwordEncoder;

    private final StreamBridge sender;

    @PostMapping
    public ResponseEntity<HttpStatus> register(@RequestBody UserRequestDto user) {
        userHandler.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/active")
    public ResponseEntity<HttpStatus> activateAccount(@RequestParam() String token){


        return new ResponseEntity<>(HttpStatus.OK);
    }
}

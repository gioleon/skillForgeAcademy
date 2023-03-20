package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.application.dto.response.UserResponseDto;
import com.skillForgeAcademy.application.handler.IUserHandler;
import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class RegisterRestController {

    @Autowired
    private IUserHandler userHandler;
    @Autowired
    private ITokenServicePort tokenRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private StreamBridge sender;

    @PostMapping
    public ResponseEntity<HttpStatus> register(@RequestBody UserRequestDto user) throws Exception {
        userHandler.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/active")
    public ResponseEntity<HttpStatus> activateAccount(@RequestParam() String token) throws Exception{
        TokenModel tokenFound = this.tokenRepository.find(token);

        // set a confirmedAt value
        this.tokenRepository.confirmToken(token);
        // change isEnable status to true
        this.userHandler.updateIsEnable(tokenFound.getUser().getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

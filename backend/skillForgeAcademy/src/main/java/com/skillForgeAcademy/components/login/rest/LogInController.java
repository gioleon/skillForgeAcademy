package com.skillForgeAcademy.components.login.rest;

import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.security.config.CustomUserDetailService;
import com.skillForgeAcademy.security.config.CustomUserDetails;
import com.skillForgeAcademy.security.jwt.JwtTokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/login")
@Slf4j
public class LogInController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping
    public ResponseEntity<HttpStatus> login(@RequestBody User user, HttpServletResponse response) throws Exception {
        Authentication authentication;

        try {
            authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(), user.getPassword()));


            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException exception){
            log.warn("CREDENTIAL NOT MATCH.");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        CustomUserDetails userDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(user.getEmail());

        if (!userDetails.isAccountActive()){
            log.warn("ACCOUNT NOT ACTIVE: {}", userDetails.getUsername());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        response.addHeader("Authentication", this.jwtTokenService.generateTokens(userDetails));

        response.getWriter().flush();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
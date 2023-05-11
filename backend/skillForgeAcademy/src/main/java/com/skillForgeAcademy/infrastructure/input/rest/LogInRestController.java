package com.skillForgeAcademy.infrastructure.input.rest;

import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import com.skillForgeAcademy.infrastructure.security.config.CustomUserDetailService;
import com.skillForgeAcademy.infrastructure.security.config.CustomUserDetails;
import com.skillForgeAcademy.infrastructure.security.jwt.JwtTokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LogInRestController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenService jwtTokenService;

    private final CustomUserDetailService customUserDetailService;

    @PostMapping
    public ResponseEntity<HttpStatus> login(@RequestBody UserRequestDto user, HttpServletResponse response) throws Exception {
        Authentication authentication;

        try {
            authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(), user.getPassword()));


            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException exception){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        CustomUserDetails userDetails = (CustomUserDetails) customUserDetailService.loadUserByUsername(user.getEmail());

        if (!userDetails.isAccountActive()){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        response.addHeader("Authentication", this.jwtTokenService.generateTokens(userDetails));

        response.getWriter().flush();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

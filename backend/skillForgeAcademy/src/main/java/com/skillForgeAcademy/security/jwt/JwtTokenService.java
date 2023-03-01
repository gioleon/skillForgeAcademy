package com.skillForgeAcademy.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.skillForgeAcademy.security.config.CustomUserDetailService;
import com.skillForgeAcademy.security.config.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtTokenService {
    private long TOKEN_VALIDITY = 86400;
    private Algorithm hmac512;
    private JWTVerifier verifier;
    private String secret;
    private CustomUserDetailService userDetailService;

    JwtTokenService(@Value("${jwt.secret}") String secret, CustomUserDetailService userDetailService) {
        this.secret = secret;
        this.hmac512 = Algorithm.HMAC512(secret);
        this.verifier = JWT.require(this.hmac512).build();
        this.userDetailService = userDetailService;
    }

    public String generateTokens(CustomUserDetails userDetails) {
        // Convert list of grantedAuthorities to string
        List<String> authorities = userDetails.getAuthorities().stream()
                .map(rol -> rol.toString()).collect(Collectors.toList());


        // Adding those authorities to a map to put them into the token.
        Map<String, String> extra = new HashMap<>();
        extra.put("id", String.valueOf(userDetails.getId()));
        extra.put("name", userDetails.getName());
        extra.put("lastName", userDetails.getLastName());
        extra.put("roles", authorities.toString());


        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withClaim("extra", extra)
                .withExpiresAt(new Date(System.currentTimeMillis()))
                .sign(this.hmac512);
    }

    public String validateTokenAndGetUsername(String token) {
        try {
            return this.verifier.verify(token).getSubject();
        } catch (JWTVerificationException e) {
            log.warn("Token invalid: {}", e.getMessage());
            return null;
        }
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String email) {

        // load a user if exists
        UserDetails userDetails = this.userDetailService.loadUserByUsername(email);

        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(), null, userDetails.getAuthorities()
        );

    }


}

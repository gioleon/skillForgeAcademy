package com.skillForgeAcademy.infrastructure.security.jwt;

import com.skillForgeAcademy.infrastructure.security.config.CustomUserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private JwtTokenService tokenService;
    private CustomUserDetailService userDetailService;

    JwtRequestFilter(JwtTokenService tokenService,
                     CustomUserDetailService userDetailService) {
        this.tokenService = tokenService;
        this.userDetailService = userDetailService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        final String headers = request.getHeader(HttpHeaders.AUTHORIZATION);

        // check if the extracted token is valid
        if (headers == null || !headers.contains("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // get token
        String token = headers.substring(7);

        // validate token and get username
        String email = this.tokenService.validateTokenAndGetUsername(token);

        if (email == null) {
            filterChain.doFilter(request, response);
            return;
        }

        var authenticationToken =
                this.tokenService.getAuthentication(email);

        SecurityContextHolder
                .getContext()
                .setAuthentication(authenticationToken);

        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));

        filterChain.doFilter(request, response);

    }
}

package com.skillForgeAcademy.security.config;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.user.application.ports.output.UserService;
import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.infrastructure.database.service.UserEntityServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetailService implements UserDetailsService {

    private UserService repository;

    CustomUserDetailService(UserEntityServiceImpl repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.repository.findByEmail(username);

        UserDetails userDetails = new CustomUserDetails(user, mapRoles(user.getRoles()));

        return userDetails;
    }

    public Collection<? extends GrantedAuthority> mapRoles(Collection<Rol> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
    }
}

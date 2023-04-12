package com.skillForgeAcademy.infrastructure.security.config;

import com.skillForgeAcademy.domain.api.IUserServicePort;
import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private IUserServicePort userServicePort;

    CustomUserDetailService(IUserServicePort repository) {
        this.userServicePort = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = this.userServicePort.findByEmail(username);

        return new CustomUserDetails(user, mapRoles(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> mapRoles(Collection<RolModel> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
    }
}

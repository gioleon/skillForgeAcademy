package com.skillForgeAcademy.security.config;

import com.skillForgeAcademy.models.rol.domain.model.Rol;
import com.skillForgeAcademy.models.user.domain.model.User;
import com.skillForgeAcademy.models.user.domain.ports.output.UserPersistencePort;
import com.skillForgeAcademy.models.user.infrastructure.postgresAdapter.adapter.UserPostgresAdapter;
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

    private UserPersistencePort repository;

    CustomUserDetailService(UserPostgresAdapter repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.repository.findByEmail(username);

        return new CustomUserDetails(user, mapRoles(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> mapRoles(Collection<Rol> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
    }
}

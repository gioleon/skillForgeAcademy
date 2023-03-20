package com.skillForgeAcademy.infrastructure.security.config;

import com.skillForgeAcademy.domain.model.RolModel;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.spi.persistence.IUserPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.UserJpaAdapter;
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

    private IUserPersistencePort repository;

    CustomUserDetailService(UserJpaAdapter repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = this.repository.findByEmail(username);

        return new CustomUserDetails(user, mapRoles(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> mapRoles(Collection<RolModel> roles) {
        return roles.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
    }
}

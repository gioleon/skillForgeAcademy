package com.skillForgeAcademy.infrastructure.security.config;

import com.skillForgeAcademy.domain.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    UserModel user;
    Collection<? extends GrantedAuthority> authorities;

    CustomUserDetails(UserModel user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName(){
        return this.user.getName();
    }

    public String getLastName() {
        return this.user.getLastName();
    }

    public long getId() {
        return this.user.getId();
    }

    public boolean isAccountActive(){
        return this.user.isEnable();
    }
}

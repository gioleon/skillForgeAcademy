package com.skillForgeAcademy.infrastructure.output.passwordencoder;

import com.skillForgeAcademy.domain.spi.passwordencoder.IPasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderAdapter implements IPasswordEncoderPort {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}

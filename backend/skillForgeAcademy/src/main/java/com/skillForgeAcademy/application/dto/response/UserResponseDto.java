package com.skillForgeAcademy.application.dto.response;

import com.skillForgeAcademy.domain.model.RolModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UserResponseDto {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private boolean isEnable;
    private Collection<RolModel> roles;
}

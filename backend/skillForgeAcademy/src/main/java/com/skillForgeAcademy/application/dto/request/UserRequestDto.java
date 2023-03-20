package com.skillForgeAcademy.application.dto.request;

import com.skillForgeAcademy.domain.model.RolModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class UserRequestDto {

    private String name;
    private String lastName;
    private String email;
    private String password;
}

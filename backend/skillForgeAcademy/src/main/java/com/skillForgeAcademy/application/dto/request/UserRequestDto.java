package com.skillForgeAcademy.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skillForgeAcademy.domain.model.RolModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    private UniversityRequestDto university;
}

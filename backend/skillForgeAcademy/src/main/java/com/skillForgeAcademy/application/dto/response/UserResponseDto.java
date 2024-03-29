package com.skillForgeAcademy.application.dto.response;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
  private long id;
  private String name;
  private String lastName;
  private String email;
  private boolean isEnable;
  private Collection<RolResponseDto> roles;
  private UniversityResponseDto university;
}

package com.skillForgeAcademy.application.dto.response;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import com.skillForgeAcademy.application.dto.request.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateResponseIdDto {
  private CourseRequestDto course;
  private UserRequestDto user;
}

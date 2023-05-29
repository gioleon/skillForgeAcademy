package com.skillForgeAcademy.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponseDto {
  private Long id;
  private CourseResponseDto course;
  private String name;
}

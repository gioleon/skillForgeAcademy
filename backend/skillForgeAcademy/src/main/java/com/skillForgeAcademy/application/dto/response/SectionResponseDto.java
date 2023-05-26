package com.skillForgeAcademy.application.dto.response;

import com.skillForgeAcademy.application.dto.request.CourseRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponseDto {
  private String id;
  private CourseResponseDto course;
  private String name;
}

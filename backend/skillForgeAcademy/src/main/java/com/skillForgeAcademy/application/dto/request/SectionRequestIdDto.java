package com.skillForgeAcademy.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionRequestIdDto {
  private Long id;
  private CourseRequestDto course;
}

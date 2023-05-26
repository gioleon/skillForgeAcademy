package com.skillForgeAcademy.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionRequestDto {
  private String id;
  private CourseRequestDto course;
  private String name;
}

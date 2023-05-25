package com.skillForgeAcademy.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TutorshipRequestDto {
  private String id;
  private SectionRequestDto section;
  private CourseRequestDto course;
  private String name;
}

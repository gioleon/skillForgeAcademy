package com.skillForgeAcademy.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutorshipResponseDto {
  private Long id;
  private SectionResponseDto section;
  private CourseResponseDto course;
  private String name;
  private String urlVideo;
}

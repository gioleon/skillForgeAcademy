package com.skillForgeAcademy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TutorshipModelId {

  private String id;
  private SectionModel section;
  private CourseModel course;
}

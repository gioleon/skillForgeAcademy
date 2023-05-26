package com.skillForgeAcademy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutorshipModel {
  private String id;
  private SectionModel section;
  private CourseModel course;
  private String name;
}

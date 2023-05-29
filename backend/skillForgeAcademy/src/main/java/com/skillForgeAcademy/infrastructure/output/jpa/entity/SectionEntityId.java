package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SectionEntityId implements Serializable {
  private Long id;
  private CourseEntity course;
}

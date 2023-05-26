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
public class InscriptionEntityId implements Serializable {
  private CourseEntity course;

  private UserEntity student;
}

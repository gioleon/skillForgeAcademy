package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorships")
@IdClass(TutorshipEntityId.class)
public class TutorshipEntity {

  @Id private Long id;

  @Id @ManyToOne private SectionEntity section;

  @Id @ManyToOne private CourseEntity course;

  private String name;
  private String urlVideo;
}

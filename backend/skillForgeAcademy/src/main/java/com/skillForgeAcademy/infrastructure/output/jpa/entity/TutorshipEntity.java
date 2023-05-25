package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "tutorship")
@IdClass(TutorshipEntityId.class)
public class TutorshipEntity {

  @Id private String id;

  @Id @ManyToOne private SectionEntity section;

  @Id @ManyToOne private CourseEntity course;

  @OneToOne private VideoEntity video;

  private String name;
}

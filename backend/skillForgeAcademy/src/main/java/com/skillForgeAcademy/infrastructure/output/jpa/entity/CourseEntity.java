package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class CourseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToMany private List<CategoryEntity> category;
  private String description;

  @ManyToOne private UserEntity owner;
  private String name;
  private String urlImage;

  @ManyToOne(fetch = FetchType.EAGER)
  private UniversityEntity university;
}

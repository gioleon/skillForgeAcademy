package com.skillForgeAcademy.infrastructure.output.jpa.entity;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "comments")
@IdClass(CommentId.class)
public class CommentEntity {

  @Id
  @ManyToOne
  private CourseEntity course;

  @Id
  @ManyToOne
  private UserEntity user;

  private String content;
}

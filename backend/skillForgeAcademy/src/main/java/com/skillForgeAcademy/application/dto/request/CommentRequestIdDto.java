package com.skillForgeAcademy.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestIdDto {

  private String id;
  private CourseRequestDto course;
  private UserRequestDto user;
}

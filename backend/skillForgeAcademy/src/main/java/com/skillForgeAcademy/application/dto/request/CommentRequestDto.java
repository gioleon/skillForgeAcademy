package com.skillForgeAcademy.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;import javax.xml.stream.events.Comment;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {

  private String id;
  private CourseRequestDto course;
  private UserRequestDto user;
  private String content;
}

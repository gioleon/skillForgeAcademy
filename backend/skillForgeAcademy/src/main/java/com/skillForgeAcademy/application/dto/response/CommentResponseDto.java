package com.skillForgeAcademy.application.dto.response;

import com.skillForgeAcademy.application.dto.request.CommentRequestIdDto;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
  private String id;
  private CourseResponseDto course;
  private UserResponseDto user;
  private String content;
}

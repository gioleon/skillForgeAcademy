package com.skillForgeAcademy.application.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {
  private long id;
  private List<CategoryResponseDto> category;
  private String name;
  private UserResponseDto owner;
  private String description;
}

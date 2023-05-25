package com.skillForgeAcademy.application.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDto {

  private long id;
  private List<CategoryRequestDto> category;
  private String name;
  private UserRequestDto owner;
  private String description;
}

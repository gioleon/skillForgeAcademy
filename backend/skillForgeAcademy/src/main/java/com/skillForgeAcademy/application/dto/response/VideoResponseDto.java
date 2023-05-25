package com.skillForgeAcademy.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoResponseDto {
  private String id;
  private TutorshipResponseDto tutorship;
  private String urlVideo;
}

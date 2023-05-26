package com.skillForgeAcademy.application.handler;

import com.skillForgeAcademy.application.dto.request.VideoRequestDto;
import com.skillForgeAcademy.application.dto.request.VideoRequestIdDto;
import com.skillForgeAcademy.application.dto.response.VideoResponseDto;
import java.util.List;

public interface IVideoHandler {
  void create(VideoRequestDto videoRequestDto);

  VideoResponseDto find(VideoRequestIdDto videoRequestIdDto);

  VideoResponseDto delete(VideoRequestIdDto videoRequestIdDto);

  List<VideoResponseDto> findAll();
}

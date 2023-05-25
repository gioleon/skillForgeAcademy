package com.skillForgeAcademy.application.handler.impl;

import com.skillForgeAcademy.application.dto.request.VideoRequestDto;
import com.skillForgeAcademy.application.dto.request.VideoRequestIdDto;
import com.skillForgeAcademy.application.dto.response.VideoResponseDto;
import com.skillForgeAcademy.application.handler.IVideoHandler;
import com.skillForgeAcademy.application.mapper.request.IVideoRequestIdMapper;
import com.skillForgeAcademy.application.mapper.request.IVideoRequestMapper;
import com.skillForgeAcademy.application.mapper.response.IVideoResponseMapper;
import com.skillForgeAcademy.domain.api.IVideoServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VideoHandlerImpl implements IVideoHandler {
  private final IVideoServicePort videoServicePort;
  private final IVideoRequestIdMapper videoRequestIdMapper;
  private final IVideoRequestMapper videoRequestMapper;
  private final IVideoResponseMapper videoResponseMapper;

  @Override
  public void create(VideoRequestDto videoRequestDto) {
    videoServicePort.create(videoRequestMapper.toModel(videoRequestDto));
  }

  @Override
  public VideoResponseDto find(VideoRequestIdDto videoRequestIdDto) {
    return videoResponseMapper.toResponse(
        videoServicePort.find(videoRequestIdMapper.toModel(videoRequestIdDto)));
  }

  @Override
  public VideoResponseDto delete(VideoRequestIdDto videoRequestIdDto) {
    return videoResponseMapper.toResponse(
        videoServicePort.find(videoRequestIdMapper.toModel(videoRequestIdDto)));
  }

  @Override
  public List<VideoResponseDto> findAll() {
    return videoResponseMapper.toResponseList(videoServicePort.findAll());
  }
}

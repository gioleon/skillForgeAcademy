package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.domain.spi.persistence.IVideoPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IVideoEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IVideoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoJpaAdapter implements IVideoPersistencePort {

  private final IVideoRepository videoRepository;
  private final IVideoEntityMapper videoEntityMapper;

  @Override
  public VideoModel create(VideoModel videoModel) {
    return null;
  }

  @Override
  public VideoModel find(Long id) {
    return null;
  }

  @Override
  public List<VideoModel> findAll() {
    return null;
  }

  @Override
  public VideoModel delete(Long id) {
    return null;
  }
}

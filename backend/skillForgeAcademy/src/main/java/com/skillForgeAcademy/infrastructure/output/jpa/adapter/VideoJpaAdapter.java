package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.domain.model.VideoModelId;
import com.skillForgeAcademy.domain.spi.persistence.IVideoPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.VideoEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.VideoEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IVideoEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IVideoEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IVideoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VideoJpaAdapter implements IVideoPersistencePort {

  private final IVideoRepository videoRepository;
  private final IVideoEntityMapper videoEntityMapper;
  private final IVideoEntityIdMapper videoEntityIdMapper;

  @Override
  public VideoModel create(VideoModel videoModel) {
    VideoEntity videoEntity = videoRepository.save(
      videoEntityMapper.toEntity(videoModel)
    );

    return videoEntityMapper.toModel(videoEntity);
  }

  @Override
  public VideoModel find(VideoModelId id) {
    VideoEntityId videoEntityId = videoEntityIdMapper.toEntityId(id);
    Optional<VideoEntity> videoEntity = videoRepository.findById(videoEntityId);

    if (videoEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }

    return videoEntityMapper.toModel(videoEntity.get());
  }

  @Override
  public List<VideoModel> findAll() {
    return videoEntityMapper.toModelList(
      (List<VideoEntity>) videoRepository.findAll()
    );
  }

  @Override
  public VideoModel delete(VideoModelId id) {
    VideoEntityId videoEntityId = videoEntityIdMapper.toEntityId(id);
    Optional<VideoEntity> videoEntity = videoRepository.findById(videoEntityId);

    if (videoEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }

    videoRepository.deleteById(videoEntityId);
    return videoEntityMapper.toModel(videoEntity.get());
  }
}

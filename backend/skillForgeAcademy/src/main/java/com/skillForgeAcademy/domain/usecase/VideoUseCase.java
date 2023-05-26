package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IVideoServicePort;
import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.domain.model.VideoModelId;
import com.skillForgeAcademy.domain.spi.persistence.IVideoPersistencePort;
import java.util.List;
import java.util.UUID;

public class VideoUseCase implements IVideoServicePort {

  private IVideoPersistencePort videoPersistencePort;

  public VideoUseCase(IVideoPersistencePort videoPersistencePort) {
    this.videoPersistencePort = videoPersistencePort;
  }

  @Override
  public VideoModel create(VideoModel videoModel) {
    videoModel.setId(UUID.randomUUID().toString());
    return videoPersistencePort.create(videoModel);
  }

  @Override
  public VideoModel find(VideoModelId id) {
    return videoPersistencePort.find(id);
  }

  @Override
  public List<VideoModel> findAll() {
    return videoPersistencePort.findAll();
  }

  @Override
  public VideoModel delete(VideoModelId id) {
    return videoPersistencePort.delete(id);
  }
}

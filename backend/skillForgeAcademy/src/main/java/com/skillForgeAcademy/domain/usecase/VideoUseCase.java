package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IVideoServicePort;
import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.domain.spi.persistence.IVideoPersistencePort;

import java.util.List;

public class VideoUseCase implements IVideoServicePort {
    private IVideoPersistencePort videoPersistencePort;

    public VideoUseCase(IVideoPersistencePort videoPersistencePort) {
        this.videoPersistencePort = videoPersistencePort;
    }

    @Override
    public VideoModel create(VideoModel videoModel) {
        return videoPersistencePort.create(videoModel);
    }

    @Override
    public VideoModel find(Long id) {
        return videoPersistencePort.find(id);
    }

    @Override
    public List<VideoModel> findAll() {
        return videoPersistencePort.findAll();
    }

    @Override
    public VideoModel delete(Long id) {
        return videoPersistencePort.delete(id);
    }
}

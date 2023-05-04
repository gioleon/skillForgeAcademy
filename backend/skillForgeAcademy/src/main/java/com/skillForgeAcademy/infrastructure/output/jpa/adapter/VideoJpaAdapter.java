package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.domain.spi.persistence.IVideoPersistencePort;

import java.util.List;

public class VideoJpaAdapter implements IVideoPersistencePort {
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

package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.domain.model.VideoModelId;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface IVideoPersistencePort
  extends GenericService<VideoModel, VideoModelId> {}

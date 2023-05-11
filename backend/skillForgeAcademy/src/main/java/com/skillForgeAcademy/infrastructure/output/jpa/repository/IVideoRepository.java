package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.VideoEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.VideoEntityId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepository
  extends CrudRepository<VideoEntity, VideoEntityId> {}

package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.VideoModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.VideoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IVideoEntityMapper {
    VideoModel toModel(VideoEntity videoEntity);
    VideoEntity toEntity(VideoModel videoModel);
    List<VideoModel> toModelList(List<VideoEntity> videoEntities);
}

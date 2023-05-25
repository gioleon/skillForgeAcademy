package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.VideoResponseDto;
import com.skillForgeAcademy.domain.model.VideoModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IVideoResponseMapper {
    VideoResponseDto toResponse(VideoModel videoModel);
    List<VideoResponseDto> toResponseList(List<VideoModel> videoModels);
}

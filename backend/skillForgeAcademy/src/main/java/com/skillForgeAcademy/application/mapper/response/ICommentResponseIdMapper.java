package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.CommentResponseIdDto;
import com.skillForgeAcademy.domain.model.CommentModelId;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICommentResponseIdMapper {
    CommentResponseIdDto toResponse(CommentModelId commentModelId);
    List<CommentResponseIdDto> toResponseList(List<CommentModelId> commentModelList);
}

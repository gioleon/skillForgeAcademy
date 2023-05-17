package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.CommentRequestIdDto;
import com.skillForgeAcademy.domain.model.CommentModelId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICommentRequestIdMapper {
  CommentModelId toModel(CommentRequestIdDto commentResponseIdDto);
}

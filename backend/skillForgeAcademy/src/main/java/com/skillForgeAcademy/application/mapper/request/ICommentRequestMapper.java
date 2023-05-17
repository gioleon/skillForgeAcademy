package com.skillForgeAcademy.application.mapper.request;

import com.skillForgeAcademy.application.dto.request.CommentRequestDto;
import com.skillForgeAcademy.domain.model.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICommentRequestMapper {
    CommentModel toModel(CommentRequestDto commentRequestDto);
}

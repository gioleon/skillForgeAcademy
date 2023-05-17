package com.skillForgeAcademy.application.mapper.response;

import com.skillForgeAcademy.application.dto.response.CommentResponseDto;
import com.skillForgeAcademy.domain.model.CommentModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICommentResponseMapper {
  CommentResponseDto toReponse(CommentModel commentModel);

  List<CommentResponseDto> toResponseList(List<CommentModel> commentModelList);
}

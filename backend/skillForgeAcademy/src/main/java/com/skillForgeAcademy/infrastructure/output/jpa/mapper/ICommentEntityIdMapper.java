package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.CommentModelId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CommentEntityId;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  unmappedSourcePolicy = ReportingPolicy.IGNORE,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ICommentEntityIdMapper {
  CommentEntityId toEntityId(CommentModelId commentModelId);
  CommentModelId toModelId(CommentEntityId commentEntityId);
}

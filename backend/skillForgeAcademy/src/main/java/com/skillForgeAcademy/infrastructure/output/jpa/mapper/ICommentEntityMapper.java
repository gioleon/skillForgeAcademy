package com.skillForgeAcademy.infrastructure.output.jpa.mapper;

import com.skillForgeAcademy.domain.model.CommentModel;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICommentEntityMapper {
    CommentModel toModel(CommentEntity commentEntity);
    CommentEntity toEntity(CommentModel commentModel);
    List<CommentModel> toModelList(List<CommentEntity> commentEntities);
}

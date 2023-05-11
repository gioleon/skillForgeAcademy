package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.model.CommentModelId;
import com.skillForgeAcademy.domain.spi.persistence.ICommentPersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CommentEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CommentEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICommentEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICommentEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICommentRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentJpaAdapter implements ICommentPersistencePort {

  private final ICommentRepository commentRepository;
  private final ICommentEntityMapper commentEntityMapper;
  private final ICommentEntityIdMapper commentEntityIdMapper;

  @Override
  public CommentModel create(CommentModel commentModel) {
    CommentEntity commentEntity = commentRepository.save(
      commentEntityMapper.toEntity(commentModel)
    );

    return commentEntityMapper.toModel(commentEntity);
  }


  @Override
  public List<CommentModel> findAll() {
    return commentEntityMapper.toModelList(
      (List<CommentEntity>) commentRepository.findAll()
    );
  }


  @Override
  public CommentModel find(CommentModelId id) {
    CommentEntityId commentEntityId = commentEntityIdMapper.toEntityId(id);
    Optional<CommentEntity> commentEntity = commentRepository.findById(commentEntityId);
    if (commentEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    return commentEntityMapper.toModel(commentEntity.get());
  }

  @Override
  public CommentModel delete(CommentModelId id) {
    CommentEntityId commentEntityId = commentEntityIdMapper.toEntityId(id);
    Optional<CommentEntity> commentEntity = commentRepository.findById(commentEntityId);
    if (commentEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    commentRepository.deleteById(commentEntityId);
    return commentEntityMapper.toModel(commentEntity.get());
  }
}

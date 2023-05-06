package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.spi.persistence.ICommentPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICommentEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICommentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentJpaAdapter implements ICommentPersistencePort {

  private final ICommentRepository commentRepository;
  private final ICommentEntityMapper commentEntityMapper;

  @Override
  public CommentModel create(CommentModel commentModel) {
    return null;
  }

  @Override
  public CommentModel find(Long id) {
    return null;
  }

  @Override
  public List<CommentModel> findAll() {
    return null;
  }

  @Override
  public CommentModel delete(Long id) {
    return null;
  }
}

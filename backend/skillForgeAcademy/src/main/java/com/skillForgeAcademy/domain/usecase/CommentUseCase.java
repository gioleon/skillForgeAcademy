package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ICommentServicePort;
import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.model.CommentModelId;
import com.skillForgeAcademy.domain.spi.persistence.ICommentPersistencePort;
import java.util.List;
import java.util.UUID;

public class CommentUseCase implements ICommentServicePort {

  private ICommentPersistencePort commentPersistencePort;

  public CommentUseCase(ICommentPersistencePort commentPersistencePort) {
    this.commentPersistencePort = commentPersistencePort;
  }

  @Override
  public CommentModel create(CommentModel commentModel) {
    commentModel.setId(UUID.randomUUID().toString());
    return commentPersistencePort.create(commentModel);
  }

  @Override
  public List<CommentModel> findAll() {
    return commentPersistencePort.findAll();
  }

  @Override
  public CommentModel find(CommentModelId id) {
    return commentPersistencePort.find(id);
  }

  @Override
  public CommentModel delete(CommentModelId id) {
    return commentPersistencePort.delete(id);
  }
}

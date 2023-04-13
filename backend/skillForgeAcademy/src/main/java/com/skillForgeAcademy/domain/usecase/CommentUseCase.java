package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.ICommentServicePort;
import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.spi.persistence.ICommentPersistencePort;

import java.util.List;

public class CommentUseCase implements ICommentServicePort {
    private ICommentPersistencePort commentPersistencePort;

    public CommentUseCase(ICommentPersistencePort commentPersistencePort) {
        this.commentPersistencePort = commentPersistencePort;
    }

    @Override
    public CommentModel create(CommentModel commentModel) {
        return commentPersistencePort.create(commentModel);
    }

    @Override
    public CommentModel find(Long id) {
        return commentPersistencePort.find(id);
    }

    @Override
    public List<CommentModel> findAll() {
        return commentPersistencePort.findAll();
    }

    @Override
    public CommentModel delete(Long id) {
        return commentPersistencePort.delete(id);
    }
}

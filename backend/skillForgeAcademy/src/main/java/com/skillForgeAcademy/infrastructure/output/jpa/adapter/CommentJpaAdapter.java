package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.spi.persistence.ICommentPersistencePort;

import java.util.List;



public class CommentJpaAdapter implements ICommentPersistencePort {
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

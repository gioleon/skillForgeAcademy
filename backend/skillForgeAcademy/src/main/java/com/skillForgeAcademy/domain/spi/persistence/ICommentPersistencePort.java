package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.model.CommentModelId;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ICommentPersistencePort extends GenericService<CommentModel, CommentModelId> {
}

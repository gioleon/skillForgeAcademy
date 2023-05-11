package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.CommentModel;
import com.skillForgeAcademy.domain.model.CommentModelId;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ICommentServicePort
  extends GenericService<CommentModel, CommentModelId> {}

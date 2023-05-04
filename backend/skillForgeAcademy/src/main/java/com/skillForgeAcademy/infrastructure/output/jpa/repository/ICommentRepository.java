package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends CrudRepository<CommentEntity, Long> {
}

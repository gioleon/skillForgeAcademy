package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CourseEntity;
import java.util.List;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends CrudRepository<CourseEntity, Long> {
  List<CourseEntity> findByOwner(UserEntity idOwner);
}

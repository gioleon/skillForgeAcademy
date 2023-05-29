package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CourseEntity;import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TutorshipEntityId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;import java.util.List;

@Repository
public interface ITutorshipRepository extends CrudRepository<TutorshipEntity, TutorshipEntityId> {
  @Query(value = "SELECT MAX(id) from tutorships", nativeQuery = true)
  Long findLastId();

  List<TutorshipEntity> findByCourse(CourseEntity course);
}

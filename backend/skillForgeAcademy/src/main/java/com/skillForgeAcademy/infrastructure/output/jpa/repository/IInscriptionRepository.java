package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CourseEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.InscriptionEntityId;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IInscriptionRepository
    extends CrudRepository<InscriptionEntity, InscriptionEntityId> {

  List<InscriptionEntity> findByStudent(UserEntity user);

  List<InscriptionEntity> findByCourse(CourseEntity course);

  @Query(
      value =
          "SELECT count(*) FROM inscriptions "
              + "WHERE student_id = :student AND course_id = :course",
      nativeQuery = true)
  Long studentIsEnroll(@Param("student") Long idStudent, @Param("course") Long idCourse);
}

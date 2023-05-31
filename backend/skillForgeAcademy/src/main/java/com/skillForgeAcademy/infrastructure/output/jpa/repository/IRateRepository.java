package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.CourseEntity;import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntityId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;import java.util.List;

@Repository
public interface IRateRepository extends CrudRepository<RateEntity, RateEntityId> {

    List<RateEntity> findByCourse(CourseEntity course);

}

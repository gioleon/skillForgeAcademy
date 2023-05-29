package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.CourseModel;import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.domain.utility.GenericService;import java.util.List;

public interface ITutorshipPersistencePort
  extends GenericService<TutorshipModel, TutorshipModelId> {
    Long findLastId();
    List<TutorshipModel> findByCourse(CourseModel course);
}

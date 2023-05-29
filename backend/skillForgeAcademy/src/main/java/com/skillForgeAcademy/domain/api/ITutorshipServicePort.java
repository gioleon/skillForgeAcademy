package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.domain.utility.GenericService;import java.util.List;

public interface ITutorshipServicePort
  extends GenericService<TutorshipModel, TutorshipModelId> {
    List<TutorshipModel> findByCourse(Long id);
}

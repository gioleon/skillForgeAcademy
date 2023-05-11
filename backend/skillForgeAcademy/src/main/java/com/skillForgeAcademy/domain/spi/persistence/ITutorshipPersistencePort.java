package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.model.TutorshipModelId;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ITutorshipPersistencePort
  extends GenericService<TutorshipModel, TutorshipModelId> {}

package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.SectionModel;
import com.skillForgeAcademy.domain.model.SectionModelId;
import com.skillForgeAcademy.domain.utility.GenericService;

public interface ISectionPersistencePort
  extends GenericService<SectionModel, SectionModelId> {}

package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.model.RateModelId;
import com.skillForgeAcademy.domain.utility.GenericService;
import java.util.List;

public interface IRatePersistencePort extends GenericService<RateModel, RateModelId> {
  List<RateModel> findByCourse(CourseModel courseModel);
}

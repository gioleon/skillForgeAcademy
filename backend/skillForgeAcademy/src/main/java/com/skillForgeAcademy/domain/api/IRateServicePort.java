package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.RateModel;
import com.skillForgeAcademy.domain.model.RateModelId;
import com.skillForgeAcademy.domain.utility.GenericService;import java.util.List;

public interface IRateServicePort
  extends GenericService<RateModel, RateModelId> {
    List<RateModel> findByCourse(Long id);
}

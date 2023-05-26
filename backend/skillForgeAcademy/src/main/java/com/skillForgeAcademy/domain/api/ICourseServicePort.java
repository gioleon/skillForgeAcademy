package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.utility.GenericService;
import java.util.List;

public interface ICourseServicePort extends GenericService<CourseModel, Long> {
  List<CourseModel> findByOwner(Long idOwner);
}

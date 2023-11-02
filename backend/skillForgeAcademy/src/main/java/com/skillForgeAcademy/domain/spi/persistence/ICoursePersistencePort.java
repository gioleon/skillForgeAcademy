package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.utility.GenericService;
import java.util.List;

public interface ICoursePersistencePort extends GenericService<CourseModel, Long> {
  List<CourseModel> findByOwner(UserModel owner);
  List<CourseModel> findByName(String courseName);
}

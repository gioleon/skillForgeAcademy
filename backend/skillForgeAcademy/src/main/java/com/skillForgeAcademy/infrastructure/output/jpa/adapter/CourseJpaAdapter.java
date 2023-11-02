package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.spi.persistence.ICoursePersistencePort;
import com.skillForgeAcademy.infrastructure.exception.NoDataFoundException;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.CourseEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.UserEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICourseEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICourseRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourseJpaAdapter implements ICoursePersistencePort {

  private final ICourseRepository courseRepository;
  private final ICourseEntityMapper courseEntityMapper;
  private final IUserEntityMapper userEntityMapper;

  @Override
  public CourseModel create(CourseModel courseModel) {
    CourseEntity courseEntity = courseRepository.save(courseEntityMapper.toEntity((courseModel)));
    return courseEntityMapper.toModel(courseEntity);
  }

  @Override
  public CourseModel find(Long id) {
    Optional<CourseEntity> courseEntity = courseRepository.findById(id);
    if (courseEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    return courseEntityMapper.toModel(courseEntity.get());
  }

  @Override
  public List<CourseModel> findAll() {
    return courseEntityMapper.toModelList((List<CourseEntity>) courseRepository.findAll());
  }

  @Override
  public CourseModel delete(Long id) {
    Optional<CourseEntity> courseEntity = courseRepository.findById(id);
    if (courseEntity.isEmpty()) {
      throw new NoDataFoundException("NO DATA FOUND");
    }
    courseRepository.deleteById(id);
    return courseEntityMapper.toModel(courseEntity.get());
  }

  @Override
  public List<CourseModel> findByOwner(UserModel owner) {
    UserEntity userEntity = userEntityMapper.toEntity(owner);
    return courseEntityMapper.toModelList(courseRepository.findByOwner(userEntity));
  }

  @Override
  public List<CourseModel> findByName(String courseName) {
    List<CourseEntity> courseEntities = courseRepository.findByName(courseName);
    return courseEntityMapper.toModelList(courseEntities);
  }

}

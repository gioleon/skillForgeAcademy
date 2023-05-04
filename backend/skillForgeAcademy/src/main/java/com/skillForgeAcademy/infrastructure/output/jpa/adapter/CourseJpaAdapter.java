package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.spi.persistence.ICoursePersistencePort;

import java.util.List;

public class CourseJpaAdapter implements ICoursePersistencePort {
    @Override
    public CourseModel create(CourseModel courseModel) {
        return null;
    }

    @Override
    public CourseModel find(Long id) {
        return null;
    }

    @Override
    public List<CourseModel> findAll() {
        return null;
    }

    @Override
    public CourseModel delete(Long id) {
        return null;
    }
}

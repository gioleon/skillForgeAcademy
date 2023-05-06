package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.SectionModel;
import com.skillForgeAcademy.domain.spi.persistence.ISectionPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ISectionEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ISectionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SectionJpaAdapter implements ISectionPersistencePort {

  private final ISectionRepository sectionRepository;
  private final ISectionEntityMapper sectionEntityMapper;

  @Override
  public SectionModel create(SectionModel sectionModel) {
    return null;
  }

  @Override
  public SectionModel find(Long id) {
    return null;
  }

  @Override
  public List<SectionModel> findAll() {
    return null;
  }

  @Override
  public SectionModel delete(Long id) {
    return null;
  }
}

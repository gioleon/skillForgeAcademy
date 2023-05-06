package com.skillForgeAcademy.infrastructure.output.jpa.adapter;

import com.skillForgeAcademy.domain.model.TutorshipModel;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITutorshipEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITutorshipRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TutorshipJpaAdapter implements ITutorshipPersistencePort {

  private final ITutorshipRepository tutorshipRepository;
  private final ITutorshipEntityMapper tutorshipEntityMapper;

  @Override
  public TutorshipModel create(TutorshipModel tutorshipModel) {
    return null;
  }

  @Override
  public TutorshipModel find(Long id) {
    return null;
  }

  @Override
  public List<TutorshipModel> findAll() {
    return null;
  }

  @Override
  public TutorshipModel delete(Long id) {
    return null;
  }
}

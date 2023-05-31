package com.skillForgeAcademy.domain.usecase;

import com.skillForgeAcademy.domain.api.IInscriptionServicePort;
import com.skillForgeAcademy.domain.model.CourseModel;
import com.skillForgeAcademy.domain.model.InscriptionModel;
import com.skillForgeAcademy.domain.model.InscriptionModelId;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.spi.persistence.IInscriptionPersistencePort;
import java.util.List;

public class InscriptionUseCase implements IInscriptionServicePort {

  private IInscriptionPersistencePort inscriptionPersistencePort;

  public InscriptionUseCase(IInscriptionPersistencePort inscriptionPersistencePort) {
    this.inscriptionPersistencePort = inscriptionPersistencePort;
  }

  @Override
  public InscriptionModel create(InscriptionModel inscriptionModel) {
    return inscriptionPersistencePort.create(inscriptionModel);
  }

  @Override
  public InscriptionModel find(InscriptionModelId id) {
    return inscriptionPersistencePort.find(id);
  }

  @Override
  public List<InscriptionModel> findAll() {
    return inscriptionPersistencePort.findAll();
  }

  @Override
  public InscriptionModel delete(InscriptionModelId id) {
    return inscriptionPersistencePort.delete(id);
  }

  @Override
  public List<InscriptionModel> findByStudent(Long idUser) {
    UserModel userModel = new UserModel();
    userModel.setId(idUser);
    return inscriptionPersistencePort.findByStudent(userModel);
  }

  @Override
  public List<InscriptionModel> findByCourse(Long idCourse) {
    CourseModel courseModel = new CourseModel();
    courseModel.setId(idCourse);

    return inscriptionPersistencePort.findByCourse(courseModel);
  }

  @Override
  public Long studentIsEnroll(Long idUser, Long idCourse) {
    return inscriptionPersistencePort.studentIsEnroll(idUser, idCourse);
  }
}

package com.skillForgeAcademy.domain.spi.persistence;

import com.skillForgeAcademy.domain.model.InscriptionModel;
import com.skillForgeAcademy.domain.model.InscriptionModelId;
import com.skillForgeAcademy.domain.model.UserModel;
import com.skillForgeAcademy.domain.utility.GenericService;
import java.util.List;

public interface IInscriptionPersistencePort
    extends GenericService<InscriptionModel, InscriptionModelId> {

  List<InscriptionModel> findByStudent(UserModel user);
  Long studentIsEnroll(Long idStudent, Long idCourse);
}

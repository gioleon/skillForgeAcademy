package com.skillForgeAcademy.domain.api;

import com.skillForgeAcademy.domain.model.InscriptionModel;
import com.skillForgeAcademy.domain.model.InscriptionModelId;
import com.skillForgeAcademy.domain.utility.GenericService;
import java.util.List;

public interface IInscriptionServicePort
    extends GenericService<InscriptionModel, InscriptionModelId> {
  List<InscriptionModel> findByStudent(Long idUser);
}

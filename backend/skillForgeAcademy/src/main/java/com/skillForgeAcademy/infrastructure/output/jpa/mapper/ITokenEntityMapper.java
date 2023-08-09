package com.skillForgeAcademy.infrastructure.output.jpa.mapper;


import com.skillForgeAcademy.domain.model.TokenActivationModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenActivationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;



@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITokenEntityMapper {
    TokenActivationModel toModel(TokenActivationEntity tokenEntity);
    TokenActivationEntity toEntity(TokenActivationModel tokenModel);
    List<TokenActivationEntity> toEntityList(List<TokenActivationModel> tokenModels);
    List<TokenActivationModel> toModelList(List<TokenActivationEntity> tokenEntityList);


}

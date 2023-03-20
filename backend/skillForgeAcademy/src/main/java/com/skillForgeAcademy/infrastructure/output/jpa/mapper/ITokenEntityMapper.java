package com.skillForgeAcademy.infrastructure.output.jpa.mapper;


import com.skillForgeAcademy.domain.model.TokenModel;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.TokenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;



@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITokenEntityMapper {
    TokenModel toModel(TokenEntity tokenEntity);
    TokenEntity toEntity(TokenModel tokenModel);
    List<TokenEntity> toEntityList(List<TokenModel> tokenModels);
    List<TokenModel> toModelList(List<TokenEntity> tokenEntityList);


}

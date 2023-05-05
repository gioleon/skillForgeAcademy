package com.skillForgeAcademy.infrastructure.output.jpa.repository;

import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateEntity;
import com.skillForgeAcademy.infrastructure.output.jpa.entity.RateId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRateRepository extends CrudRepository<RateEntity, RateId> {



}
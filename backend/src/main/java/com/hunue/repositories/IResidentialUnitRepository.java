package com.hunue.repositories;

import com.hunue.entities.ResidentialUnit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IResidentialUnitRepository extends CrudRepository<ResidentialUnit, Long> {
List<ResidentialUnit> findByName(String name);

@Query("Select r from ResidentialUnit r") // uso de jpa / entidades no tablas
List<ResidentialUnit> buscarToditos();
}

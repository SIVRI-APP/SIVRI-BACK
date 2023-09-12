package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAreaRepository extends JpaRepository<AreaEntity,Integer> {


 }

package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAreaRepository extends JpaRepository<AreaEntity,Integer> {


 }

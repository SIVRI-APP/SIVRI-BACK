package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.FacultadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacultadRepository extends JpaRepository<FacultadEntity,Integer> {
}

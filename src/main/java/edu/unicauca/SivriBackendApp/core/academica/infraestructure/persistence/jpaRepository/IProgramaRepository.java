package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgramaRepository extends JpaRepository<ProgramaEntity, Integer> {

}

package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgramaRepository extends JpaRepository<ProgramaEntity, Integer> {

}

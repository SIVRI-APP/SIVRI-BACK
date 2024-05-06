package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProgramaRepository extends JpaRepository<ProgramaEntity, Integer> {

}

package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaRepository extends JpaRepository<ProgramaEntity, Integer> {

}

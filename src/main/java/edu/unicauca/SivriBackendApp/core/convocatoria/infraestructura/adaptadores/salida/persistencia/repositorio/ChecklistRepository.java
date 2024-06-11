package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ChecklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<ChecklistEntity, Long>{

}

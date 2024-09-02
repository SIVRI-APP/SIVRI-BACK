package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaProyectoDocumentoConvocatoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EvidenciaProyectoDocumentoConvocatoriaRepository extends JpaRepository<EvidenciaProyectoDocumentoConvocatoriaEntity, Long>{


}

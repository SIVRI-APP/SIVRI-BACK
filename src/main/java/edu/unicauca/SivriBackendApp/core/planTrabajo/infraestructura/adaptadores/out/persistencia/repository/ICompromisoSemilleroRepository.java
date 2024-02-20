package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.CompromisoSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompromisoSemilleroRepository extends JpaRepository<CompromisoSemilleroEntity,Integer> {
}

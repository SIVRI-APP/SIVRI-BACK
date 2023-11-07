package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.CompromisoSemilleroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompromisoSemilleroRepository extends JpaRepository<CompromisoSemilleroEntity,Integer> {
}

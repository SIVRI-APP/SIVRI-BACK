package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.TipoFinanciacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITipoFinanciacionRepository extends JpaRepository<TipoFinanciacionEntity, Long>{
}

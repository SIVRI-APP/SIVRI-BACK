package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.LineaInvestigacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILineaInvestigacionRepository extends JpaRepository<LineaInvestigacionEntity,Integer> {
    public List<LineaInvestigacionEntity> findBySemilleroId(int semilleroId);
}

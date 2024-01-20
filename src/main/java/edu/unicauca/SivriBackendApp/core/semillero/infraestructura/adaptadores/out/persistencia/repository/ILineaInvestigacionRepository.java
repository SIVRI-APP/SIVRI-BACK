package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILineaInvestigacionRepository extends JpaRepository<LineaInvestigacionEntity,Integer> {
    public List<LineaInvestigacionEntity> findBySemilleroId(int semilleroId);
}

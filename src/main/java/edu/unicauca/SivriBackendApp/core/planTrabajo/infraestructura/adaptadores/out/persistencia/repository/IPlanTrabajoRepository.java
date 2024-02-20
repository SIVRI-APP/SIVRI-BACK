package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.PlanTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlanTrabajoRepository extends JpaRepository<PlanTrabajoEntity,Integer> {
    public List<PlanTrabajoEntity> findBySemilleroId(int semilleroId);
}

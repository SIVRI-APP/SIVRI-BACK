package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActividadPlanTrabajoRepository extends JpaRepository<ActividadPlanTrabajoEntity, Integer> {
    public List<ActividadPlanTrabajoEntity> findByPlanTrabajoId(int planId);
}

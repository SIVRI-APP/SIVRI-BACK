package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.PlanTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlanTrabajoRepository extends JpaRepository<PlanTrabajoEntity,Integer> {
    public List<PlanTrabajoEntity> findBySemilleroId(int semilleroId);
}

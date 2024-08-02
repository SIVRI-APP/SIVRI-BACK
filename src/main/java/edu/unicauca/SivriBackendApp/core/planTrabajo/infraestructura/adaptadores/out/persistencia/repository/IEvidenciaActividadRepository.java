package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.EvidenciaActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEvidenciaActividadRepository extends JpaRepository<EvidenciaActividadEntity, Integer> {
    @Query(value = "SELECT COALESCE((SELECT ea.id FROM evidencia_actividad ea WHERE ea.actividadId = :id), 0) AS id;",nativeQuery = true)
    public Integer existexActividadId(@Param("id") int id);

}

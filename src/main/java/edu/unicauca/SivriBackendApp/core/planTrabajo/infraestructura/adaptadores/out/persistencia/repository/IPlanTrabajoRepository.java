package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerPlanTrabajoxanio;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.PlanTrabajoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPlanTrabajoRepository extends JpaRepository<PlanTrabajoEntity,Integer> {
    @Query(value = "SELECT COUNT(*) > 0  AS existe_registro " +
            "FROM plan_trabajo pt " +
            "WHERE pt.anio = (:anio) and pt.semilleroId=(:idSemillero);",nativeQuery = true)
    public Integer existePorIdsemilleroyAnio(Integer idSemillero,Integer anio);
    public List<PlanTrabajoEntity> findBySemilleroId(int semilleroId);

    //obtiene un plan de trabajo por año con sus respectivas actividades, si el usuario ingresa la fecha inicio y fin de las actividades
    @Query(value = "SELECT  apt.id,pt.id as idPlan,apt.evidenciaId,apt.actividad,cs.nombre as compromiso,apt.fechaInicio, " +
            "apt.fechaFin, concat_ws(' ' , u.nombres, u.apellidos) as responsable  " +
            "               FROM actividad_plan_trabajo apt " +
            "               INNER JOIN compromiso_semillero cs ON apt.compromisoSemilleroId=cs.id " +
            "               INNER JOIN usuario u ON u.id=apt.responsableId " +
            "               INNER JOIN plan_trabajo pt ON pt.id=apt.planTrabajoId " +
            "               WHERE " +
            "                   ((apt.fechaInicio >= (:fechaInicio) AND apt.fechaFin <= (:fechaFin)) " +
            "                   OR (:fechaInicio is null or :fechaFin is null)) " +
            "                   AND pt.anio=(:anio) AND pt.semilleroId=(:idSemillero);", nativeQuery = true)
    public Page<List<ObtenerPlanTrabajoxanio>> obtenerPlanxAnio(
            @Param("anio") Integer anio,
            @Param("idSemillero") Integer idSemillero,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable
    );
}

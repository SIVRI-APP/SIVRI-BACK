package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarActividadesConFiltro;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.time.LocalDate;
import java.util.List;

public interface IActividadPlanTrabajoRepository extends JpaRepository<ActividadPlanTrabajoEntity, Integer> {
    public List<ActividadPlanTrabajoEntity> findByPlanTrabajoId(int planId);
    /*  ** consulta de filtrar actividades por fechainicio, dfechaFin Y nombre

    * SELECT apt.objetivo, apt.actividad,cs.nombre,apt.fechaInicio,apt.fechaFin, concat_ws(' ' , u.nombres, u.apellidos) as nombre " +
            "   FROM actividad_plan_trabajo apt " +
            "   INNER JOIN compromiso_semillero cs ON apt.compromisoSemilleroId=cs.id " +
            "   INNER JOIN usuario u ON u.id=apt.responsableId " +
            "   WHERE " +
            "       ((apt.fechaInicio >= fechaInicio and apt.fechaFin <= fechaFin) OR (fechaInicio is null or fechaFin is null)) " +
            "       and (lower(concat_ws(' ' , u.nombres, u.apellidos)) like %:nombre% or lower(concat_ws(' ' , u.nombres, u.apellidos)) = " +
            "       coalesce(lower(concat_ws(' ' , nombres, apellidos)), lower(concat_ws( ' ' , u.nombres,u.apellidos) )) or  (concat_ws(' ' , nombres, apellidos) is null));
    * */
    @Query(value = "SELECT apt.id,apt.objetivo, apt.actividad,cs.nombre as compromiso,apt.fechaInicio,apt.fechaFin, concat_ws(' ' , u.nombre, u.apellido) as responsable " +
            "   FROM actividad_plan_trabajo apt " +
            "   INNER JOIN compromiso_semillero cs ON apt.compromisoSemilleroId=cs.id " +
            "   INNER JOIN usuario u ON u.id=apt.responsableId " +
            "   WHERE " +
            "       ((apt.fechaInicio >= :fechaInicio AND apt.fechaFin <= :fechaFin) " +
            "       OR (:fechaInicio is null or :fechaFin is null))" +
            "       AND apt.planTrabajoId=(:idPlan);",nativeQuery = true)
    Page<List<ListarActividadesConFiltro>> listarActividadesConFiltro(
            @Param("idPlan") Integer idPlan,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable
    );

}

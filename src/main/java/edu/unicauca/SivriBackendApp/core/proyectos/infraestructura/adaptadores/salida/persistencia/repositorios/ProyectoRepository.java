package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Long>{

    Boolean existsByNombre(String nombre);

    @Query("SELECT proyecto " +
            "FROM ProyectoEntity proyecto " +
            "LEFT JOIN FETCH proyecto.convocatoria " +
            "LEFT JOIN FETCH proyecto.enfoquesDiferenciales " +
            "LEFT JOIN FETCH proyecto.integrantes " +
            "LEFT JOIN FETCH proyecto.lineasDeInvestigacion " +
            "WHERE proyecto.id = :proyectoId"
    )
    Optional<ProyectoInformacionDetalladaProyeccion> obtenerProyectoInformacionDetallada(@Param("proyectoId") long proyectoId);

    @Query(value = "select " +
            " p.id, " +
            " p.nombre, " +
            " p.estado, " +
            " p.fechaInicio, " +
            " p.fechaFin, " +
            " c.tipoFinanciacion, " +
            " org.nombre as 'organismoNombre' " +
            "from " +
            " proyecto p " +
            "left join convocatoria c on p.convocatoriaId = c.id " +
            "left join cooperacion cop on cop.proyectoId = p.id " +
            "left join organismo_de_investigacion org on org.id = cop.organismoDeInvestigacionId " +
            "left join integrante_proyecto ip on ip.proyectoId = p.id " +
            "where " +
            " (:id is null or LOWER(p.id) like LOWER(CONCAT('%', :id, '%')))   " +
            "    and (:nombre is null or LOWER(p.nombre) like LOWER(CONCAT('%', :nombre, '%'))) " +
            "    and (:estado is null or LOWER(p.estado) like LOWER(CONCAT('%', :estado, '%'))) " +
            "    and (:fechaInicio is null or LOWER(p.fechaInicio) like LOWER(CONCAT('%', :fechaInicio, '%'))) " +
            "    and (:fechaFin is null or LOWER(p.fechaFin) like LOWER(CONCAT('%', :fechaFin, '%'))) " +
            "    and (:organismoDeInvestigacionId is null or LOWER(org.id) like LOWER(CONCAT('%', :organismoDeInvestigacionId, '%'))) " +
            "    and (:tipoFinanciacion is null or LOWER(c.tipoFinanciacion) like LOWER(CONCAT('%', :tipoFinanciacion, '%'))) " +
            "    and (:usuarioAutenticadoId is null or LOWER(ip.usuarioId) like LOWER(CONCAT('%', :usuarioAutenticadoId, '%')))"
            , nativeQuery = true)
    Page<ProyectoListarConFiltroProyeccion> listarConFiltro(
            @Param("id") String id,
            @Param("nombre") String nombre,
            @Param("estado") String estado,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin,
            @Param("organismoDeInvestigacionId") Integer organismoDeInvestigacionId,
            @Param("tipoFinanciacion") String tipoFinanciacion,
            @Param("usuarioAutenticadoId") Long usuarioAutenticadoId,
            @PageableDefault(sort = "id") Pageable pageable
    );
}

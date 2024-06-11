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
            " c.id, " +
            " c.nombre, " +
            " c.estado, " +
            " c.tipoFinanciacion " +
            "from " +
            " convocatoria c  " +
            "where  " +
            " (:id IS NULL OR LOWER(c.id) LIKE LOWER(CONCAT('%', :id, '%'))) AND " +
            " (:nombre IS NULL OR LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
            " (:estado IS NULL OR LOWER(c.estado) LIKE LOWER(CONCAT('%', :estado, '%'))) AND " +
            " (:tipoFinanciacion IS NULL OR LOWER(c.tipoFinanciacion) LIKE LOWER(CONCAT('%', :tipoFinanciacion, '%'))) "
            , nativeQuery = true)
    Page<ProyectoListarConFiltroProyeccion> listarConFiltro(
            @Param("id") String id,
            @Param("nombre") String nombre,
            @PageableDefault(sort = "nombre") Pageable pageable);
}

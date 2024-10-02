package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.*;
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


    @Query("SELECT DISTINCT proyecto " +
            "FROM ProyectoEntity proyecto " +
            "WHERE proyecto.id = :proyectoId"
    )
    Optional<ProyectoInformacionDetalladaProyeccion> obtenerProyectoInformacionDetallada1(@Param("proyectoId") long proyectoId);

    @Query(value = "SELECT DISTINCT p " +
            "FROM ProyectoEntity p " +
            "LEFT JOIN FETCH p.convocatoria " +
            "WHERE p.id = :proyectoId"
    )
    Optional<ProyectoConvocatoriaProyeccion> obtenerProyectoInformacionDetallada2(@Param("proyectoId") long proyectoId);

    @Query("SELECT DISTINCT proyecto " +
            "FROM ProyectoEntity proyecto " +
            "LEFT JOIN FETCH proyecto.evidenciasDocumentosConvocatoria " +
            "WHERE proyecto.id = :proyectoId"
    )
    Optional<ProyectoEvidenciasDocumentosProyeccion> obtenerProyectoInformacionDetallada3(@Param("proyectoId") long proyectoId);

    @Query("SELECT DISTINCT proyecto " +
            "FROM ProyectoEntity proyecto " +
            "LEFT JOIN FETCH proyecto.integrantes " +
            "WHERE proyecto.id = :proyectoId"
    )
    Optional<ProyectoIntegrantesProyeccion> obtenerProyectoInformacionDetalladaIntegrantes(@Param("proyectoId") long proyectoId);

    @Query("SELECT DISTINCT proyecto " +
            "FROM ProyectoEntity proyecto " +
            "LEFT JOIN FETCH proyecto.compromisos " +
            "WHERE proyecto.id = :proyectoId"
    )
    Optional<ProyectoCompromisosProyeccion> obtenerProyectoInformacionDetalladaCompromisos(@Param("proyectoId") long proyectoId);


    @Query(value = "SELECT " +
            "    p.id, " +
            "    p.nombre, " +
            "    p.estado, " +
            "    p.FECHA_INICIO, " +
            "    p.FECHA_FIN, " +
            "    c.TIPO_FINANCIACION, " +
            "    org.nombre AS \"organismoNombre\" " +
            "FROM proyecto p " +
            "LEFT JOIN convocatoria c ON p.CONVOCATORIA_ID = c.id " +
            "LEFT JOIN cooperacion cop ON cop.PROYECTO_ID = p.id " +
            "LEFT JOIN organismo_de_investigacion org ON org.id = cop.ORGANISMO_DE_INVESTIGACION_ID  " +
            "LEFT JOIN integrante_proyecto ip ON ip.PROYECTO_ID = p.id " +
            "WHERE " +
            "    (:id IS NULL OR LOWER(p.id) LIKE LOWER('%' || :id || '%')) " +
            "    AND (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER('%' || :nombre || '%')) " +
            "    AND (:estado IS NULL OR LOWER(p.estado) LIKE LOWER('%' || :estado || '%')) " +
            "    AND (:fechaInicio IS NULL OR p.FECHA_INICIO = :fechaInicio) " +
            "    AND (:fechaFin IS NULL OR p.FECHA_FIN = :fechaFin) " +
            "    AND (:organismoDeInvestigacionId IS NULL OR org.id = :organismoDeInvestigacionId) " +
            "    AND (:tipoFinanciacion IS NULL OR LOWER(c.TIPO_FINANCIACION) LIKE LOWER('%' || :tipoFinanciacion || '%')) " +
            "    AND (:usuarioAutenticadoId IS NULL OR ip.USUARIO_ID = :usuarioAutenticadoId)"
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

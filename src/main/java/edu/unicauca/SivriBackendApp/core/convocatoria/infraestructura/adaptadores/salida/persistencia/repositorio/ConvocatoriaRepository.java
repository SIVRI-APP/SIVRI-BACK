package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConvocatoriaRepository extends JpaRepository<ConvocatoriaEntity, Long>{
    boolean existsByNombre(String nombre);

    @Query("SELECT convocatoria " +
            "FROM ConvocatoriaEntity convocatoria " +
            "LEFT JOIN FETCH convocatoria.checklist checklist " +
            "LEFT JOIN FETCH checklist.documentoConvocatoria doc " +
            "WHERE convocatoria.id = :convocatoriaId"
    )
    Optional<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(@Param("convocatoriaId") long solicitudUsuarioId);

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
    Page<ConvocatoriaListarConFiltroProyeccion> listarConFiltro(
            @Param("id") String id,
            @Param("nombre") String nombre,
            @Param("estado") String estado,
            @Param("tipoFinanciacion") String tipoFinanciacion,
            @PageableDefault(sort = "nombre") Pageable pageable);
}

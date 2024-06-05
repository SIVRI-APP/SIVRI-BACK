package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioSolicitudEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioSolicitudRepository extends JpaRepository<UsuarioSolicitudEntity, Long> {

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    @Query(value = "SELECT " +
            "  u.id, " +
            "  u.correo, " +
            "  u.tipoDocumento, " +
            "  u.numeroDocumento, " +
            "  u.nombre, " +
            "  u.apellido, " +
            "  u.tipoUsuario, " +
            "  u.estado " +
            "FROM " +
            "  usuario_solicitud u " +
            "WHERE " +
            "  (LOWER(u.correo) LIKE COALESCE(LOWER(CONCAT('%', :correo, '%')), LOWER(u.correo)) OR :correo IS NULL) AND " +
            "  (LOWER(u.tipoDocumento) LIKE COALESCE(LOWER(CONCAT('%', :tipoDocumento, '%')), LOWER(u.tipoDocumento)) OR :tipoDocumento IS NULL) AND " +
            "  (LOWER(u.numeroDocumento) LIKE COALESCE(LOWER(CONCAT('%', :numeroDocumento, '%')), LOWER(u.numeroDocumento)) OR :numeroDocumento IS NULL) AND " +
            "  (LOWER(u.nombre) LIKE COALESCE(LOWER(CONCAT('%', :nombre, '%')), LOWER(u.nombre)) OR :nombre IS NULL) AND " +
            "  (LOWER(u.apellido) LIKE COALESCE(LOWER(CONCAT('%', :apellido, '%')), LOWER(u.apellido)) OR :apellido IS NULL) AND " +
            "  (LOWER(u.tipoUsuario) LIKE COALESCE(LOWER(CONCAT('%', :tipoUsuario, '%')), LOWER(u.tipoUsuario)) OR :tipoUsuario IS NULL) AND " +
            "  (LOWER(u.estado) LIKE COALESCE(LOWER(CONCAT('%', :estado, '%')), LOWER(u.estado)) OR :estado IS NULL) AND " +
            "  (LOWER(u.creadoPorUsuarioId) LIKE COALESCE(LOWER(CONCAT('%', :creadoPorUsuarioId, '%')), LOWER(u.creadoPorUsuarioId)) OR :creadoPorUsuarioId IS NULL) "
            , nativeQuery = true)
    Page<UsuarioSolicitudListarConFiltroProyeccion> listarConFiltro(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("tipoUsuario") String tipoUsuario,
            @Param("estado") String estado,
            @Param("creadoPorUsuarioId") Long creadoPorUsuarioId,
            @PageableDefault(sort = "id") Pageable pageable);


    @Query("SELECT usuario " +
            "FROM UsuarioSolicitudEntity usuario " +
            "LEFT JOIN FETCH usuario.observaciones obs " +
            "LEFT JOIN FETCH obs.conversacion conv " +
            "WHERE usuario.id = :solicitudUsuarioId"
    )
    Optional<UsuarioSolicitudInformacionDetalladaProyeccion> obtenerSolicitudUsuarioInformacionDetallada(@Param("solicitudUsuarioId") long solicitudUsuarioId);

    @Query(" SELECT COUNT(obs.id) " +
            "FROM UsuarioSolicitudEntity usuario " +
            "JOIN usuario.observaciones obs " +
            "WHERE usuario.id = :solicitudUsuarioId"
    )
    Integer contarObservacionesPendientesDeUnaSolicitudDeUsuario(@Param("solicitudUsuarioId") long solicitudUsuarioId);

}

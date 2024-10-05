package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyeccion;
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
            " u.id, " +
            " u.correo, " +
            " u.TIPO_DOCUMENTO , " +
            " u.NUMERO_DOCUMENTO , " +
            " u.nombre, " +
            " u.apellido, " +
            " u.TIPO_USUARIO , " +
            " u.estado " +
            "FROM usuario_solicitud u " +
            "WHERE " +
            " (:correo IS NULL OR LOWER(u.correo) LIKE LOWER('%' || :correo || '%')) " +
            " AND (:tipoDocumento IS NULL OR LOWER(u.TIPO_DOCUMENTO) LIKE LOWER('%' || :tipoDocumento || '%')) " +
            " AND (:numeroDocumento IS NULL OR LOWER(u.NUMERO_DOCUMENTO) LIKE LOWER('%' || :numeroDocumento|| '%')) " +
            " AND (:nombre IS NULL OR LOWER(u.nombre) LIKE LOWER('%' || :nombre || '%')) " +
            " AND (:apellido IS NULL OR LOWER(u.apellido) LIKE LOWER('%' || :apellido || '%')) " +
            " AND (:tipoUsuario IS NULL OR LOWER(u.TIPO_USUARIO) LIKE LOWER('%' || :tipoUsuario|| '%')) " +
            " AND (:estado IS NULL OR LOWER(u.estado) LIKE LOWER('%' || :estado|| '%')) " +
            " AND (:creadoPorUsuarioId IS NULL OR LOWER(u.CREADO_POR_USUARIO_ID) LIKE LOWER('%' || :creadoPorUsuarioId|| '%')) "
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
            "WHERE usuario.id = :solicitudUsuarioId AND obs.resuelta = false "
    )
    Integer contarObservacionesPendientesDeUnaSolicitudDeUsuario(@Param("solicitudUsuarioId") long solicitudUsuarioId);

}

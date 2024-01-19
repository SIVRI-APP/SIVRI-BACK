package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudEliminadoProgramadoProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformaciónDetalladaProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioSolicitudEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.Optional;

public interface UsuarioSolicitudRepository extends JpaRepository<UsuarioSolicitudEntity, Long> {

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    @Query(value = "SELECT " +
            "  u.id, " +
            "  u.correo, " +
            "  u.tipoDocumento, " +
            "  u.numeroDocumento, " +
            "  u.nombres, " +
            "  u.apellidos, " +
            "  u.tipoUsuario, " +
            "  u.estado " +
            "FROM " +
            "  usuario_solicitud u " +
            "WHERE " +
            "  (:grupoId IS NULL OR u.grupoId = :grupoId) AND " +
            "  (LOWER(u.correo) LIKE COALESCE(LOWER(CONCAT('%', :correo, '%')), LOWER(u.correo)) OR :correo IS NULL) AND " +
            "  (LOWER(u.tipoDocumento) LIKE COALESCE(LOWER(CONCAT('%', :tipoDocumento, '%')), LOWER(u.tipoDocumento)) OR :tipoDocumento IS NULL) AND " +
            "  (LOWER(u.numeroDocumento) LIKE COALESCE(LOWER(CONCAT('%', :numeroDocumento, '%')), LOWER(u.numeroDocumento)) OR :numeroDocumento IS NULL) AND " +
            "  (LOWER(u.nombres) LIKE COALESCE(LOWER(CONCAT('%', :nombres, '%')), LOWER(u.nombres)) OR :nombres IS NULL) AND " +
            "  (LOWER(u.apellidos) LIKE COALESCE(LOWER(CONCAT('%', :apellidos, '%')), LOWER(u.apellidos)) OR :apellidos IS NULL) AND " +
            "  (LOWER(u.tipoUsuario) LIKE COALESCE(LOWER(CONCAT('%', :tipoUsuario, '%')), LOWER(u.tipoUsuario)) OR :tipoUsuario IS NULL) AND " +
            "  (LOWER(u.estado) LIKE COALESCE(LOWER(CONCAT('%', :estado, '%')), LOWER(u.estado)) OR :estado IS NULL) "
            , nativeQuery = true)
    Page<UsuarioSolicitudListarConFiltroProyección> listarConFiltro(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombres") String nombres,
            @Param("apellidos") String apellidos,
            @Param("tipoUsuario") String tipoUsuario,
            @Param("estado") String estado,
            @Param("grupoId") Integer grupoId,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);

    @Query(value = "select " +
            " u.id, " +
            " u.numeroDocumento, " +
            " u.tipoDocumento, " +
            " u.nombres, " +
            " u.apellidos, " +
            " u.correo, " +
            " u.telefono, " +
            " u.cvLac, " +
            " u.estado, " +
            " u.sexo, " +
            " u.tipoUsuario, " +
            " u.nota, " +
            " COALESCE(rg.rolGrupo, null) AS nombreRol, " +
            " COALESCE(orga.nombre, null) AS nombreGrupo, " +
            " COALESCE(fac.nombre, null) AS nombreFacultad, " +
            " COALESCE(dep.nombre, null) AS nombreDepartamento, " +
            " COALESCE(prog.nombre, null) AS nombrePrograma " +
            "from " +
            " usuario_solicitud u " +
            "left join departamento dep on u.departamentoId = dep.id " +
            "left join facultad fac on u.facultadId = fac.idFacultad " +
            "left join programa prog on u.programaId = prog.id " +
            "left join grupo grup on u.grupoId = grup.grupoId  " +
            "left join organismo_de_investigacion orga on grup.grupoId = orga.id " +
            "left join rol_grupo rg on u.rolGrupoId = rg.id  " +
            "where " +
            " u.id = :solicitudUsuarioId"
            , nativeQuery = true)
    Optional<UsuarioSolicitudInformaciónDetalladaProyección> obtenerSolicitudUsuario(
            @Param("solicitudUsuarioId") long solicitudUsuarioId);

    @Query(value = "with ObservacionesConRango as ( " +
            "select " +
            " us.id, " +
            " MIN(uso.fechaObservación) as fechaObservacionMinima " +
            "from " +
            " usuario_solicitud us " +
            "join usuario_solicitud_observaciones uso on " +
            " uso.solicitudUsuarioId = us.id " +
            "group by " +
            " us.id " +
            ") " +
            "select " +
            " id, " +
            " fechaObservacionMinima as fechaObservación, " +
            " DATE_SUB(CURDATE(), interval 3 month) as fechaLimite " +
            "from " +
            " ObservacionesConRango " +
            "where " +
            " fechaObservacionMinima < DATE_SUB(CURDATE(), interval 3 month);"
            , nativeQuery = true)
    List<UsuarioSolicitudEliminadoProgramadoProyección> eliminadoProgramado();
    
}

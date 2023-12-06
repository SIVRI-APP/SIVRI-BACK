package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.ListarUsuarioSolicitudConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioSolicitudEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

public interface UsuarioSolicitudRepository extends JpaRepository<UsuarioSolicitudEntity, Long> {

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    @Query(value = "select  " +
            "  u.id, " +
            "  u.correo, " +
            "  u.tipoDocumento, " +
            "  u.numeroDocumento, " +
            "  u.nombres, " +
            "  u.apellidos, " +
            "  u.tipoUsuario, " +
            "  u.estado " +
            "from " +
            "  usuario_solicitud u " +
            "where " +
            "  (LOWER(u.correo) like coalesce(LOWER(CONCAT('%', :correo, '%')), LOWER(u.correo)) " +
            "    or :correo is null) " +
            "  and (LOWER(u.tipoDocumento) like coalesce(LOWER(CONCAT('%', :tipoDocumento, '%')), LOWER(u.tipoDocumento)) " +
            "    or :tipoDocumento is null) " +
            "  and (LOWER(u.numeroDocumento) like coalesce(LOWER(CONCAT('%', :numeroDocumento, '%')), LOWER(u.numeroDocumento)) " +
            "    or :numeroDocumento is null) " +
            "  and (LOWER(u.nombres) like coalesce(LOWER(CONCAT('%', :nombres, '%')), LOWER(u.nombres)) " +
            "    or :nombres is null) " +
            "  and (LOWER(u.apellidos) like coalesce(LOWER(CONCAT('%', :apellidos, '%')), LOWER(u.apellidos)) " +
            "    or :apellidos is null) " +
            "  and (LOWER(u.tipoUsuario) like coalesce(LOWER(CONCAT('%', :tipoUsuario, '%')), LOWER(u.tipoUsuario)) " +
            "    or :tipoUsuario is null) " +
            "  and (LOWER(u.estado) like coalesce(LOWER(CONCAT('%', :estado, '%')), LOWER(u.estado)) " +
            "    or :estado is null); "
            , nativeQuery = true)
    Page<ListarUsuarioSolicitudConFiltroProyección> listarConFiltro(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombres") String nombres,
            @Param("apellidos") String apellidos,
            @Param("tipoUsuario") String tipoUsuario,
            @Param("estado") String estado,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);

    @Query(value = "select  " +
            "  u.id, " +
            "  u.correo, " +
            "  u.tipoDocumento, " +
            "  u.numeroDocumento, " +
            "  u.nombres, " +
            "  u.apellidos, " +
            "  u.tipoUsuario, " +
            "  u.estado " +
            "from " +
            "  usuario_solicitud u " +
            "where " +
            "  u.grupoId = :grupoId " +
            "  and (LOWER(u.correo) like coalesce(LOWER(CONCAT('%', :correo, '%')), LOWER(u.correo)) " +
            "    or :correo is null) " +
            "  and (LOWER(u.tipoDocumento) like coalesce(LOWER(CONCAT('%', :tipoDocumento, '%')), LOWER(u.tipoDocumento)) " +
            "    or :tipoDocumento is null) " +
            "  and (LOWER(u.numeroDocumento) like coalesce(LOWER(CONCAT('%', :numeroDocumento, '%')), LOWER(u.numeroDocumento)) " +
            "    or :numeroDocumento is null) " +
            "  and (LOWER(u.nombres) like coalesce(LOWER(CONCAT('%', :nombres, '%')), LOWER(u.nombres)) " +
            "    or :nombres is null) " +
            "  and (LOWER(u.apellidos) like coalesce(LOWER(CONCAT('%', :apellidos, '%')), LOWER(u.apellidos)) " +
            "    or :apellidos is null) " +
            "  and (LOWER(u.tipoUsuario) like coalesce(LOWER(CONCAT('%', :tipoUsuario, '%')), LOWER(u.tipoUsuario)) " +
            "    or :tipoUsuario is null) " +
            "  and (LOWER(u.estado) like coalesce(LOWER(CONCAT('%', :estado, '%')), LOWER(u.estado)) " +
            "    or :estado is null); "
            , nativeQuery = true)
    Page<ListarUsuarioSolicitudConFiltroProyección> listarConFiltroPorGrupo(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombres") String nombres,
            @Param("apellidos") String apellidos,
            @Param("tipoUsuario") String tipoUsuario,
            @Param("estado") String estado,
            @Param("grupoId") Integer grupoId,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);
}

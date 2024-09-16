package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByCorreo(String correo);

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    @Query(value = "SELECT " +
            "  u.id, " +
            "  u.correo, " +
            "  u.tipoDocumento, " +
            "  u.numeroDocumento, " +
            "  u.nombre, " +
            "  u.apellido, " +
            "  u.tipoUsuario " +
            "FROM " +
            "  usuario u " +
            "WHERE " +
            "  (LOWER(u.correo) LIKE COALESCE(LOWER(CONCAT('%', :correo, '%')), LOWER(u.correo)) OR :correo IS NULL) AND " +
            "  (LOWER(u.tipoDocumento) LIKE COALESCE(LOWER(CONCAT('%', :tipoDocumento, '%')), LOWER(u.tipoDocumento)) OR :tipoDocumento IS NULL) AND " +
            "  (LOWER(u.numeroDocumento) LIKE COALESCE(LOWER(CONCAT('%', :numeroDocumento, '%')), LOWER(u.numeroDocumento)) OR :numeroDocumento IS NULL) AND " +
            "  (LOWER(u.nombre) LIKE COALESCE(LOWER(CONCAT('%', :nombre, '%')), LOWER(u.nombre)) OR :nombre IS NULL) AND " +
            "  (LOWER(u.apellido) LIKE COALESCE(LOWER(CONCAT('%', :apellido, '%')), LOWER(u.apellido)) OR :apellido IS NULL) AND " +
            "  (LOWER(u.tipoUsuario) LIKE COALESCE(LOWER(CONCAT('%', :tipoUsuario, '%')), LOWER(u.tipoUsuario)) OR :tipoUsuario IS NULL)  "
            , nativeQuery = true)
    Page<UsuarioListarConFiltroProyeccion> listarConFiltro(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("tipoUsuario") String tipoUsuario,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);

    @Query(value = "select " +
            " u.id, " +
            " u.numeroDocumento, " +
            " u.tipoDocumento, " +
            " u.nombre, " +
            " u.apellido, " +
            " u.correo, " +
            " u.telefono, " +
            " u.cvLac, " +
            " u.sexo, " +
            " u.tipoUsuario, " +
            " dep.nombre as departamentoNombre, " +
            " pro.nombre as programaNombre " +
            "from " +
            " usuario u " +
            "left join departamento dep on dep.id = u.departamentoId  " +
            "left join programa pro on pro.id = u.programaId  " +
            "where " +
            " u.id = :usuarioId"
            , nativeQuery = true)
    Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetallada(
            @Param("usuarioId") long usuarioId);

    @Query(value = "select " +
            " u.id, " +
            " u.numeroDocumento, " +
            " u.tipoDocumento, " +
            " u.nombre, " +
            " u.apellido, " +
            " u.correo, " +
            " u.telefono, " +
            " u.cvLac, " +
            " u.sexo, " +
            " u.tipoUsuario, " +
            " dep.nombre as departamentoNombre, " +
            " pro.nombre as programaNombre " +
            "from " +
            " usuario u " +
            "left join departamento dep on dep.id = u.departamentoId  " +
            "left join programa pro on pro.id = u.programaId  " +
            "where " +
            " u.numeroDocumento = :usuarioNumDoc AND " +
            " u.tipoDocumento = :tipoDocumento"
            , nativeQuery = true)
    Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetalladaPorDocumento(
            @Param("usuarioNumDoc") long usuarioNumDoc,
            @Param("tipoDocumento") String tipoDocumento
    );
}

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
            "    u.id, " +
            "    u.correo, " +
            "    u.tipo_documento, " +
            "    u.numero_documento, " +
            "    u.nombre, " +
            "    u.apellido, " +
            "    u.tipo_usuario " +
            "FROM usuario u " +
            "WHERE " +
            "    (:correo IS NULL OR LOWER(u.correo) LIKE LOWER('%' || :correo || '%')) AND " +
            "    (:tipoDocumento IS NULL OR LOWER(u.tipo_documento) LIKE LOWER('%' || :tipoDocumento || '%')) AND " +
            "    (:numeroDocumento IS NULL OR LOWER(u.numero_documento) LIKE LOWER('%' || :numeroDocumento || '%')) AND " +
            "    (:nombre IS NULL OR LOWER(u.nombre) LIKE LOWER('%' || :nombre || '%')) AND " +
            "    (:apellido IS NULL OR LOWER(u.apellido) LIKE LOWER('%' || :apellido || '%')) AND " +
            "    (:tipoUsuario IS NULL OR LOWER(u.tipo_usuario) LIKE LOWER('%' || :tipoUsuario || '%'))"
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
            "  u.id,  " +
            "  u.NUMERO_DOCUMENTO ,  " +
            "  u.TIPO_DOCUMENTO ,  " +
            "  u.nombre,  " +
            "  u.apellido,  " +
            "  u.correo,  " +
            "  u.telefono,  " +
            "  u.CV_LAC ,  " +
            "  u.sexo,  " +
            "  u.TIPO_USUARIO ,  " +
            "  dep.nombre as departamentoNombre,  " +
            "  pro.nombre as programaNombre  " +
            "from  " +
            " usuario u  " +
            " left join departamento dep on dep.id = u.DEPARTAMENTO_ID   " +
            " left join programa pro on pro.id = u.PROGRAMA_ID   " +
            "where  " +
            "  u.id = :usuarioId"
            , nativeQuery = true)
    Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetallada(
            @Param("usuarioId") long usuarioId);

    @Query(value = "select " +
            " u.id,  " +
            " u.numero_Documento,  " +
            " u.tipo_Documento,  " +
            " u.nombre,  " +
            " u.apellido,  " +
            " u.correo,  " +
            " u.telefono,  " +
            " u.cv_Lac,  " +
            " u.sexo,  " +
            " u.tipo_Usuario,  " +
            " dep.nombre as departamentoNombre,  " +
            " pro.nombre as programaNombre  " +
            "from  " +
            " usuario u  " +
            " left join departamento dep on dep.id = u.departamento_Id   " +
            " left join programa pro on pro.id = u.programa_Id   " +
            "where  " +
            "  u.numero_Documento = :usuarioNumDoc AND  " +
            "  u.tipo_Documento = :tipoDocumento"
            , nativeQuery = true)
    Optional<UsuarioInformacionDetalladaProyeccion> obtenerUsuarioInformacionDetalladaPorDocumento(
            @Param("usuarioNumDoc") long usuarioNumDoc,
            @Param("tipoDocumento") String tipoDocumento
    );
}

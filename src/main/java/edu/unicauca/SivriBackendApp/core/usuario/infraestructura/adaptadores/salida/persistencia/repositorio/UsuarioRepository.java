package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByCorreo (String correo);

    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

    @Query(value = "SELECT u.id, u.correo, u.tipoDocumento, u.numeroDocumento, u.nombres, u.apellidos, u.tipoUsuario " +
            "FROM usuario u " +
            "WHERE " +
            "  (LOWER(u.correo) LIKE COALESCE(LOWER(CONCAT('%', :correo, '%')), LOWER(u.correo)) OR :correo IS NULL) AND " +
            "  (LOWER(u.tipoDocumento) LIKE COALESCE(LOWER(CONCAT('%', :tipoDocumento, '%')), LOWER(u.tipoDocumento)) OR :tipoDocumento IS NULL) AND " +
            "  (LOWER(u.numeroDocumento) LIKE COALESCE(LOWER(CONCAT('%', :numeroDocumento, '%')), LOWER(u.numeroDocumento)) OR :numeroDocumento IS NULL) AND " +
            "  (LOWER(u.nombres) LIKE COALESCE(LOWER(CONCAT('%', :nombres, '%')), LOWER(u.nombres)) OR :nombres IS NULL) AND " +
            "  (LOWER(u.apellidos) LIKE COALESCE(LOWER(CONCAT('%', :apellidos, '%')), LOWER(u.apellidos)) OR :apellidos IS NULL) AND " +
            "  (LOWER(u.tipoUsuario) LIKE COALESCE(LOWER(CONCAT('%', :tipoUsuario, '%')), LOWER(u.tipoUsuario)) OR :tipoUsuario IS NULL)  "
            , nativeQuery = true)
    Page<List<UsuarioListarConFiltroProyección>> listarConFiltro(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombres") String nombres,
            @Param("apellidos") String apellidos,
            @Param("tipoUsuario") String tipoUsuario,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);

}

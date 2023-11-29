package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.ListarConFiltro;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones.InformacionDetalladaUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioEntity;
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

    @Query(value = "SELECT usu.id, usu.nombres, usu.apellidos, usu.tipoDocumento, usu.numeroDocumento, usu.correo, usu.telefono, usu.tipoUsuario, usu.sexo, usu.cvLac    " +
            "FROM usuario usu   " +
            "WHERE usu.tipoDocumento = :tipoDocumento AND usu.numeroDocumento = :numeroDocumento"
            , nativeQuery = true)
    Optional<InformacionDetalladaUsuario> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);

    Optional<UsuarioEntity> findByCorreo(String correo);

    Boolean existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);

    Boolean existsByCorreo(String correo);
    
    @Query(value = "SELECT u.id, u.correo, u.tipoDocumento, u.numeroDocumento, u.nombres, u.apellidos, u.tipoUsuario " +
            "FROM usuario u " +
            "WHERE " +
            "    (LOWER(u.correo) = COALESCE(LOWER(:correo), LOWER(u.correo)) OR :correo IS NULL) " +
            "    AND (LOWER(u.tipoDocumento) = COALESCE(LOWER(:tipoDocumento), LOWER(u.tipoDocumento)) OR :tipoDocumento IS NULL) " +
            "    AND (LOWER(u.numeroDocumento) = COALESCE(LOWER(:numeroDocumento), LOWER(u.numeroDocumento)) OR :numeroDocumento IS NULL) " +
            "    AND (LOWER(u.nombres) = COALESCE(LOWER(:nombres), LOWER(u.nombres)) OR :nombres IS NULL) " +
            "    AND (LOWER(u.apellidos) = COALESCE(LOWER(:apellidos), LOWER(u.apellidos)) OR :apellidos IS NULL) " +
            "    AND (LOWER(u.tipoUsuario) = COALESCE(LOWER(:tipoUsuario), LOWER(u.tipoUsuario)) OR :tipoUsuario IS NULL);"
            , nativeQuery = true)
    Page<List<ListarConFiltro>> listarConFiltro(
            @Param("correo") String correo,
            @Param("tipoDocumento") String tipoDocumento,
            @Param("numeroDocumento") String numeroDocumento,
            @Param("nombres") String nombres,
            @Param("apellidos") String apellidos,
            @Param("tipoUsuario") String tipoUsuario,
            @PageableDefault(size = 10, page = 0, sort = "id") Pageable pageable);
}

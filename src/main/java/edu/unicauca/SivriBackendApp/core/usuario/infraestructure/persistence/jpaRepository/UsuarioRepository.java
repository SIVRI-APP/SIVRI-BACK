package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(value = "SELECT usu.id, usu.nombres, usu.apellidos, usu.tipoDocumento, usu.numeroDocumento, usu.correo, usu.telefono, usu.tipoUsuario    " +
            "FROM usuario usu   " +
            "WHERE usu.tipoDocumento = :tipoDocumento AND usu.numeroDocumento = :numeroDocumento"
            , nativeQuery = true)
    Optional<ValidarExistenciaUsuarioSistema> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);

    Optional<UsuarioEntity> findByCorreo(String correo);

    Boolean existsByCorreoAndTipoDocumentoAndNumeroDocumento(String correo, String tipoDocumento, String numeroDocumento);
}

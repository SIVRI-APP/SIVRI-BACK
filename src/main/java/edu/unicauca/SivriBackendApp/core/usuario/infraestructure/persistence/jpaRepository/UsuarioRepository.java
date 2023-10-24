package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntityID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UsuarioEntityID> {

    @Query(value = "SELECT u.numeroDocumento, u.tipoDocumento, u.nombres, u.apellidos " +
            "FROM usuario u " +
            "INNER JOIN rol_usuario ru ON u.numeroDocumento = ru.usuarioNumeroDocumento AND u.tipoDocumento = ru.usuarioTipoDocumento " +
            "INNER JOIN rol_academico ra ON ru.rolAcademicoId = ra.id " +
            "WHERE u.numeroDocumento = :numeroDoc AND u.tipoDocumento = :tipoDoc AND ru.estado = 1"
            , nativeQuery = true)
    Optional<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(@Param("numeroDoc") String numeroDoc, @Param("tipoDoc") String tipoDoc);
}

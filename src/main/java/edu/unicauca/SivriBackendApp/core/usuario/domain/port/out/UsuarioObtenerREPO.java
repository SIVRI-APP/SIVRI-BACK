package edu.unicauca.SivriBackendApp.core.usuario.domain.port.out;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioObtenerREPO {

    Optional<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento);

    Boolean validarExistencia(TipoDocumento tipoDocumento, String numeroDocumento);

    Boolean validarExistenciaCorreo(String correo);
}

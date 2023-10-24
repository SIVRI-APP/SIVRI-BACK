package edu.unicauca.SivriBackendApp.core.usuario.domain.port.out;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;

import java.util.Optional;

public interface UsuarioObtenerREPO {
    Optional<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento);
}

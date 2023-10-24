package edu.unicauca.SivriBackendApp.core.usuario.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;

public interface UsuarioObtenerCU {
    Respuesta<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento);
}

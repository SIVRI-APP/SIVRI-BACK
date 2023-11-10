package edu.unicauca.SivriBackendApp.core.usuario.domain.port.out;


import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;

import java.util.Optional;

public interface UsuarioObtenerREPO {

    Optional<ValidarExistenciaUsuarioSistema> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);

    Boolean existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);

    Boolean existsByCorreo(String correo);

}

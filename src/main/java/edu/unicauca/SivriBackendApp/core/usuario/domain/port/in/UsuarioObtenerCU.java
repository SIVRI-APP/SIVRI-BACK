package edu.unicauca.SivriBackendApp.core.usuario.domain.port.in;


import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;

import java.util.Optional;

public interface UsuarioObtenerCU {

    Respuesta<ValidarExistenciaUsuarioSistema> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);

    Boolean existsByCorreoAndTipoDocumentoAndNumeroDocumento(String correo, String tipoDocumento, String numeroDocumento);
}

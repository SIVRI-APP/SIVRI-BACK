package edu.unicauca.SivriBackendApp.core.usuario.domain.port.in;


import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;


public interface UsuarioObtenerCU {

    Respuesta<ValidarExistenciaUsuarioSistema> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);
    Respuesta<Boolean> existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento);
    Respuesta<Boolean> existsByCorreo(String correo);
    Respuesta<Boolean> existsById(Long id);
}

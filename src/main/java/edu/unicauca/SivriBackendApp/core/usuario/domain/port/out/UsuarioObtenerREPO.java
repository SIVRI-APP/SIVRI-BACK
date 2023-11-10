package edu.unicauca.SivriBackendApp.core.usuario.domain.port.out;


import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioObtenerREPO {

    Optional<ValidarExistenciaUsuarioSistema> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento);

    Boolean existsByCorreoAndTipoDocumentoAndNumeroDocumento(String correo, String tipoDocumento, String numeroDocumento);
    Usuario guardar(Usuario usuario);


}

package edu.unicauca.SivriBackendApp.core.usuario.domain.port.in;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;

import java.util.List;

public interface MetadataCU {
    Respuesta<List<TipoDocumento>> obtenerTiposDocumento();
    Respuesta<List<Sexo>> obtenerSexo();
    Respuesta<List<TipoUsuario>> obtenerTiposUsuario();
}

package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoUsuario;

import java.util.List;

public interface MetadataCU {
    Respuesta<List<TipoDocumento>> obtenerTiposDocumento();
    Respuesta<List<Sexo>> obtenerSexo();
    Respuesta<List<TipoUsuario>> obtenerTiposUsuario();
}

package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;

import java.util.List;

public interface MetadataCU {
    Respuesta<List<TipoDocumento>> obtenerTiposDocumento();
    Respuesta<List<Sexo>> obtenerSexo();
    Respuesta<List<TipoUsuario>> obtenerTiposUsuario();
}

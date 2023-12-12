package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyección;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UsuarioObtenerCU {

    Respuesta<Page<List<UsuarioSolicitudListarConFiltroProyección>>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario);
}

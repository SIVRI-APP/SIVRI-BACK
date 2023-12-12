package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListar;
import org.springframework.data.domain.Page;


public interface UsuarioSolicitudObservacionesObtenerCU {

    Respuesta<Page<UsuarioSolicitudObservaciónListar>> listar(int pageNo, int pageSize, long solicitudUsuarioId);

}

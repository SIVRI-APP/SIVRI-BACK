package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioSolicitudObservacionesObtenerREPO {

    Page<UsuarioSolicitudObservaciónListar> listar(Pageable pageable, long solicitudUsuarioId);
    Integer solicitudConObservacionesPendientes(long solicitudUsuarioId);
}

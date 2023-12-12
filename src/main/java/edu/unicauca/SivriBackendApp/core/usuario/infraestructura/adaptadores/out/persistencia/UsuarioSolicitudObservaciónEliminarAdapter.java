package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObservaciónEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioSolicitudObservaciónEliminarAdapter implements UsuarioSolicitudObservaciónEliminarREPO {

    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    @Override
    public boolean eliminar(long solicitudUsuarioObservaciónId) {
        usuarioSolicitudObservacionesRepository.deleteById(solicitudUsuarioObservaciónId);

        return true;
    }
}

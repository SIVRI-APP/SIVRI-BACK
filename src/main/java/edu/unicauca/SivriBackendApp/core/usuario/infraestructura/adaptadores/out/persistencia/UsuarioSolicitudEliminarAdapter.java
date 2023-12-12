package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioSolicitudEliminarAdapter implements UsuarioSolicitudEliminarREPO {

    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    @Override
    public boolean eliminar(long solicitudUsuarioId) {
        usuarioSolicitudRepository.deleteById(solicitudUsuarioId);

        return true;
    }
}

package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudEliminadoProgramadoProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UsuarioSolicitudEliminarAdapter implements UsuarioSolicitudEliminarREPO {

    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    @Override
    public boolean eliminar(long solicitudUsuarioId) {
        usuarioSolicitudRepository.deleteById(solicitudUsuarioId);

        return true;
    }

    @Override
    public List<UsuarioSolicitudEliminadoProgramadoProyección> eliminadoProgramado() {
        return usuarioSolicitudRepository.eliminadoProgramado();
    }
}

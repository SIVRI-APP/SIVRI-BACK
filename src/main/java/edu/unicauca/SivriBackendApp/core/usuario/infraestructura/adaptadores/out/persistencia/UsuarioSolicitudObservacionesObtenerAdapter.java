package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObservacionesObtenerREPO;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListar;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class UsuarioSolicitudObservacionesObtenerAdapter implements UsuarioSolicitudObservacionesObtenerREPO {

    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    @Override
    public Page<UsuarioSolicitudObservaciónListar> listar(Pageable pageable, long solicitudUsuarioId) {
        return usuarioSolicitudObservacionesRepository.listar(solicitudUsuarioId, pageable);
    }
}

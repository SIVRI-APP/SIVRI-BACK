package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de eliminación de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudEliminarAdapter implements UsuarioSolicitudEliminarREPO {

    /**
     * Repositorio de UsuarioSolicitud que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;

    /**
     * Elimina una solicitud de usuario por su identificador único.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario a eliminar.
     * @return true si la eliminación fue exitosa, de lo contrario, false.
     */
    @Override
    public boolean eliminar(long solicitudUsuarioId) {
        usuarioSolicitudRepository.deleteById(solicitudUsuarioId);
        return true;
    }

}

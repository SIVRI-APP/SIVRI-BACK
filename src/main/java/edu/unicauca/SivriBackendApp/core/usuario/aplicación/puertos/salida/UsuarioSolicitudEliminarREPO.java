package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudEliminadoProgramadoProyección;

import java.util.List;

/**
 * La interfaz UsuarioSolicitudEliminarREPO define el puerto de salida para la eliminación
 * y obtención de información sobre solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudEliminarREPO {

    /**
     * Elimina una solicitud de usuario por su identificador único.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return True si la eliminación fue exitosa, de lo contrario, False.
     */
    boolean eliminar(long solicitudUsuarioId);

    /**
     * Obtiene una lista de proyecciones que representan las solicitudes de usuario eliminadas programadamente.
     *
     * @return Lista de proyecciones de solicitudes de usuario eliminadas programadamente.
     */
    List<UsuarioSolicitudEliminadoProgramadoProyección> eliminadoProgramado();
}

package edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.CredencialRepository;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * El validador UsuarioSolicitudValidador realiza la validación de la creación de solicitudes de usuario.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudValidador {

    /** Repositorio de Credenciales */
    private final CredencialRepository credencialRepository;

    /** Puertos de salida */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;
    private final UsuarioRepository usuarioRepository;

    /**
     * Valída que no existan duplicados en la creación de solicitudes de usuario y que se tiene el acceso correctá para realizar la solicitud.
     *
     * @param usuario {@link UsuarioSolicitud}
     * @throws ReglaDeNegocioException Sí se encuentran duplicados en la solicitud de usuario.
     */
    public void validarLaCreacionDeUnaSolicitudDeUsuario(UsuarioSolicitud usuario) {
        boolean respuesta;

        // Verificar si la solicitud ya existe
        respuesta = usuarioSolicitudRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.solicitud.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Verificar si el usuario ya existe
        respuesta = usuarioRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Verificar si las credenciales ya existen
        respuesta = credencialRepository.existsByEmail(usuario.getCorreo());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.creación.credenciales.ya.existen", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }
    }

    /**
     * Valída que no existan duplicados en la creación de solicitudes de usuario y que se tiene el acceso correctá para realizar la solicitud.
     *
     * @param solicitudUsuarioId Id de la solicitud de usuario a validar para su aprobación
     * @throws ReglaDeNegocioException Sí se encuentran duplicados en la solicitud de usuario.
     */
    public void validarAprobacionDeUnaSolicitudDeUsuario(Long solicitudUsuarioId){
        // Verifica que la solicitud exista
        if (!usuarioSolicitudRepository.existsById(solicitudUsuarioId)){
            throw new ReglaDeNegocioException("bad.solicitud.no.existe", List.of(String.valueOf(solicitudUsuarioId)));
        }

        // Verifica que no se tengan observaciones pendientes por resolver
        if(usuarioSolicitudRepository.contarObservacionesPendientesDeUnaSolicitudDeUsuario(solicitudUsuarioId) != 0){
            throw new ReglaDeNegocioException("bad.no.se.puede.aprobar.solicitud.observaciones.pendientes");
        }
    }
}


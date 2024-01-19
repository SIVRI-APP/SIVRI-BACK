package edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * El validador UsuarioSolicitudValidador realiza la validación de la creación de solicitudes de usuario.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudValidador {

    private final RepositorioCredencial repositorioCredencial;
    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;
    private final UsuarioObtenerREPO usuarioObtenerREPO;

    /**
     * Valida que no existan duplicados en la creación de solicitudes de usuario.
     *
     * @param usuario Solicitud de usuario a validar.
     * @return true si la validación es exitosa.
     * @throws ReglaDeNegocioException Si se encuentran duplicados en la solicitud de usuario.
     */
    public boolean validaciónSolicitudUsuarioNoExiste(UsuarioSolicitud usuario) {
        boolean respuesta;

        // Verificar si la solicitud ya existe
        respuesta = usuarioSolicitudObtenerREPO.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.solicitud.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Verificar si el usuario ya existe
        respuesta = usuarioObtenerREPO.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Verificar si las credenciales ya existen
        respuesta = repositorioCredencial.existsByEmail(usuario.getCorreo());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.creación.credenciales.ya.existen", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // TODO: Validar si usuario.grupoId es válido y el usuario no pertenece ya a ese grupo

        // TODO: Validar si usuario.rolGrupoId es válido y el usuario no tiene ya ese rol asignado dentro del grupo

        return true;
    }
}


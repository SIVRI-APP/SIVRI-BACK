package edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class UsuarioSolicitudValidador {

    private final RepositorioCredencial repositorioCredencial;
    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;
    private final UsuarioObtenerREPO usuarioObtenerREPO;

    public boolean validaciónSolicitudUsuarioNoExiste(UsuarioSolicitud usuario) {
        boolean respuesta;

        // Existe la solicitud?
        respuesta = usuarioSolicitudObtenerREPO.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta){
            throw new ReglaDeNegocioException("bad.solicitud.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Existe el usuario?
        respuesta = usuarioObtenerREPO.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta){
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Existe la credencial?
        respuesta = repositorioCredencial.existsByEmail(usuario.getCorreo());
        if (respuesta){
            throw new ReglaDeNegocioException("bad.creación.credenciales.ya.existen", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // TODO Miguel usuario.grupoId es valido y el usuario no pertenece ya a ese grupo

        // TODO Miguel usuario.rolGrupoId es valido y el usuario no tiene ya ese rol asignado dentro del grupo

        return true;
    }

}

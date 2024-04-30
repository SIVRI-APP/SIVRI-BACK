package edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * El validador UsuarioValidador realiza la validación de la creación de usuarios.
 */
@Component
@AllArgsConstructor
public class UsuarioValidador {

    private final RepositorioCredencial repositorioCredencial;
    private final UsuarioObtenerREPO usuarioObtenerREPO;

    /**
     * Valida la creación de un usuario.
     *
     * @param usuario Usuario a validar.
     * @return true si la validación es exitosa.
     * @throws ReglaDeNegocioException Si se encuentran duplicados en la creación del usuario.
     */
    public boolean validaciónCreaciónUsuario(Usuario usuario) {
        boolean respuesta;

        // Verificar si las credenciales ya existen
        respuesta = repositorioCredencial.existsByEmail(usuario.getCorreo());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.creación.credenciales.ya.existen", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        // Verificar si el usuario ya existe
        respuesta = usuarioObtenerREPO.existsByCorreoOrTipoDocumentoAndNumeroDocumento(usuario.getCorreo(), usuario.getTipoDocumento(), usuario.getNumeroDocumento());
        if (respuesta) {
            throw new ReglaDeNegocioException("bad.usuario.ya.existe", List.of(usuario.getTipoDocumento().name(), usuario.getNumeroDocumento(), usuario.getCorreo()));
        }

        return true;
    }
}


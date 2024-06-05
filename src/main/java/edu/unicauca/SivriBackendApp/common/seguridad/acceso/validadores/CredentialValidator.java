package edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CreateCredentialDTORequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.CredencialRepository;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Clase encargada de validar credenciales de usuario.
 */
@Component
@AllArgsConstructor
public class CredentialValidator {

    /** Repositorio de credenciales para acceder a la base de datos */
    private final CredencialRepository credencialRepository;

    /** Repositorio de usuarios para acceder a la base de datos */
    private final UsuarioRepository usuarioRepository;

    /**
     * Crea una nueva credencial de usuario.
     *
     * @param credential DTO de solicitud para crear la credencial
     * @return La nueva credencial creada
     * @throws ReglaDeNegocioException si la credencial ya existe o el usuario no existe
     */
    public Credencial createCredential(CreateCredentialDTORequest credential) {

        // Verifica si la credencial ya existe
        credentialDoesNotExist(credential.getEmail(), credential.getUserId());

        // Verifica y retorna el Usuario si existe
        UsuarioEntity user = userExists(credential.getUserId());

        // Crea y devuelve la nueva credencial
        return Credencial.builder()
                .user(user)
                .email(credential.getEmail())
                .password(credential.getPassword())
                .build();
    }

    /**
     * Verifica si ya existe una credencial con el correo o el ID de usuario proporcionados.
     *
     * @param email Correo de la credencial a verificar
     * @param userId Id de usuario de la credencial a verificar
     * @throws ReglaDeNegocioException si la credencial ya existe
     */
    private void credentialDoesNotExist(String email, long userId) {
        // Busca una credencial por correo electrónico o ID de usuario
        Optional<Credencial> credencialByEmail = credencialRepository.findByEmail(email);
        Optional<Credencial> credencialByUserId = credencialRepository.findByUserId(userId);

        // Lanza una excepción si se encuentra una credencial existente
        if (credencialByEmail.isPresent() || credencialByUserId.isPresent()) {
            throw new ReglaDeNegocioException("bad.credentials.ya.existen");
        }
    }

    /**
     * Verifica si un usuario existe en la base de datos.
     *
     * @param userId Id del usuario a verificar
     * @return El usuario si existe
     * @throws ReglaDeNegocioException si el usuario no existe
     */
    private UsuarioEntity userExists(Long userId) {
        // Busca un usuario por su ID
        return usuarioRepository.findById(userId)
                .orElseThrow(() -> new ReglaDeNegocioException("bad.usuario.no.existe"));
    }

}

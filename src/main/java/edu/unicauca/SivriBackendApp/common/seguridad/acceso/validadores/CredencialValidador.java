package edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CredencialValidador {

    private final RepositorioCredencial repositorioCredencial;
    private final UsuarioRepository usuarioRepository;

    public Credencial validaciónParaCrearCredencial(RegistroCredencialPetición credencial) {
        credencialNoExiste(credencial.getEmail(), credencial.getUsuarioId());

        Optional<UsuarioEntity> usuario = usuarioRepository.findById(credencial.getUsuarioId());
        if (usuario.isEmpty()){
            throw new ReglaDeNegocioException("bad.usuario.no.existe");
        }

        return Credencial.builder()
                .email(credencial.getEmail())
                .password(credencial.getPassword())
                .usuario(usuario.get())
                .build();
    }

    public boolean credencialNoExiste(String correo, long usuarioId){
        Optional<Credencial> credencialByEmail = repositorioCredencial.findByEmail(correo);
        Optional<Credencial> credencialByUsuarioId = repositorioCredencial.findByUsuarioId(usuarioId);

        if (credencialByEmail.isPresent() || credencialByUsuarioId.isPresent()){
            throw new ReglaDeNegocioException("bad.credentials.ya.existen");
        }

        return true;
    }
}

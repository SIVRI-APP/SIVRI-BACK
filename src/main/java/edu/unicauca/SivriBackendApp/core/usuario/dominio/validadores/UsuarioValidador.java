package edu.unicauca.SivriBackendApp.core.usuario.dominio.validadores;


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
public class UsuarioValidador {

    private final RepositorioCredencial repositorioCredencial;
    private final UsuarioRepository usuarioRepository;

    public Credencial credencialNoExisteValidación(RegistroCredencialPetición credencial) {
        Optional<Credencial> credencialByEmail = repositorioCredencial.findByEmail(credencial.getEmail());
        Optional<Credencial> credencialByUsuarioId = repositorioCredencial.findByUsuarioId(credencial.getUsuarioId());
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(credencial.getUsuarioId());

        if (credencialByEmail.isPresent() || credencialByUsuarioId.isPresent()){
            throw new ReglaDeNegocioException("bad.credentials.ya.existen");
        }

        if (usuario.isEmpty()){
            throw new ReglaDeNegocioException("bad.usuario.no.existe");
        }

        return Credencial.builder()
                .email(credencial.getEmail())
                .password(credencial.getPassword())
                .usuario(usuario.get())
                .build();
    }
}

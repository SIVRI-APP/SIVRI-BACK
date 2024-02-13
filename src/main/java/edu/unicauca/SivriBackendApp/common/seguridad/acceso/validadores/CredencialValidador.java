package edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores;


import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Random;

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

    public int códigoAleatorioParaRecuperarContraseña(){
        limpiarCódigosAntiguosRecuperaciónDeContraseña();

        int existe = 0;
        int codigo = 0;
        do {
            Random random = new Random();
            codigo =  random.nextInt(900000) + 100000; // Rango de 100000 a 999999

            existe = repositorioCredencial.códigoAleatorioParaRecuperarContraseñaExiste(codigo);
        }while (existe > 0);

        return codigo;
    }

    public Credencial validarCodigoRecuperarContraseña(String email, int codigoRecuperarContraseña){

        // Código existe y coincide con el correo y se solicitó recuperar la contraseña
        int respuestaBD = repositorioCredencial.validarCodigoRecuperarContraseña(email, codigoRecuperarContraseña);

        if (respuestaBD != 1){
            throw new ReglaDeNegocioException("bad.recuperar.contraseña");
        }

        Optional<Credencial> credencial = repositorioCredencial.findByEmail(email);

        if (credencial.isEmpty()){
            throw new ReglaDeNegocioException("bad.recuperar.contraseña");
        }

        return credencial.get();
    }

    private void limpiarCódigosAntiguosRecuperaciónDeContraseña(){
        repositorioCredencial.limpiarCódigosAntiguosRecuperaciónDeContraseña();
    }
}

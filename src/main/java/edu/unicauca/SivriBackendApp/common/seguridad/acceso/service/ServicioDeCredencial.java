package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CambioContraseñaPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores.CredencialValidador;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class ServicioDeCredencial {

  private final RepositorioCredencial repositorioCredencial;
  private final UsuarioRepository usuarioRepository;
  private final CredencialValidador credencialValidador;
  private final PasswordEncoder passwordEncoder;

  public Boolean registrarCredencial(RegistroCredencialPetición request) {

    //Válida que la credencial no exista y retorna un objeto Credencial.
    Credencial nuevaCredencial = credencialValidador.credencialNoExisteValidación(request);

    repositorioCredencial.save(nuevaCredencial);

    return true;
  }

  public Boolean cambiarContraseña(CambioContraseñaPetición request, Principal connectedUser) {

    var user = (Credencial) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

    // check if the current password is correct
    if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
      throw new IllegalStateException("Wrong password");
    }
    // check if the two new passwords are the same
    if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
      throw new IllegalStateException("Password are not the same");
    }

    // update the password
    user.setPassword(passwordEncoder.encode(request.getNewPassword()));

    // save the new password
    repositorioCredencial.save(user);

    return true;
  }

}

package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;

import edu.unicauca.SivriBackendApp.common.email.dto.MetaData;
import edu.unicauca.SivriBackendApp.common.email.dto.SendRequest;
import edu.unicauca.SivriBackendApp.common.email.service.SendMessageService;
import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CambioContraseñaPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores.CredencialValidador;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ServicioDeCredencial {

  private final RepositorioCredencial repositorioCredencial;
  private final CredencialValidador credencialValidador;
  private final PasswordEncoder passwordEncoder;
  private final SendMessageService sendMessageService;

  public Boolean registrarCredencial(RegistroCredencialPetición petición) {

    // Codificar contraseña
    petición.setPassword(passwordEncoder.encode(petición.getPassword()));

    //Válida que la credencial no exista y retorna un objeto Credencial.
    Credencial nuevaCredencial = credencialValidador.validaciónParaCrearCredencial(petición);

    repositorioCredencial.save(nuevaCredencial);

    return true;
  }

  public Respuesta olvideMiContraseña(String email){
    Optional<Credencial> respuestaBd = repositorioCredencial.findByEmail(email);

    if (!respuestaBd.isPresent()){
      throw new ReglaDeNegocioException("bad.email.credencial.no.existe", List.of(email));
    }

    Credencial credencial = respuestaBd.get();
    credencial.setRecuperarContraseña(credencialValidador.códigoAleatorioParaRecuperarContraseña());
    credencial.setRecuperarContraseñaFechaCreacion(LocalDate.now());

    repositorioCredencial.save(credencial);

    enviarCorreoOlvideContraseña(credencial);

    return new RespuestaHandler<>(200, "ok.envio.correo.cambio.contraseña", List.of(email), "", true).getRespuesta();
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

  public Boolean recuperarContraseña(String email, String nuevaClave, int codigoRecuperarContraseña){
    Credencial credencial = credencialValidador.validarCodigoRecuperarContraseña(email, codigoRecuperarContraseña);
    credencial.setPassword(passwordEncoder.encode(nuevaClave));

    repositorioCredencial.save(credencial);
    return true;
  }

  /**
   * Envía un correo para solicitar la recuperacion de una contraseña.
   *
   * @param credencial Objeto Credencial que contiene la información del solicitante.
   * @return Respuesta que indica el resultado del envío del correo.
   */
  private Respuesta enviarCorreoOlvideContraseña(Credencial credencial) {
    List<MetaData> metaData = new ArrayList<>();
    metaData.add(MetaData.builder()
            .key("correo")
            .value(credencial.getEmail())
            .build());
    metaData.add(MetaData.builder()
            .key("codigo")
            .value(String.valueOf(credencial.getRecuperarContraseña()))
            .build());

    return sendMessageService.sendMessage(SendRequest.builder()
            .to(credencial.getEmail())
            .subject("Recuperar contraseña SIVRI")
            .template(2)
            .metaData(metaData)
            .build());
  }



}

package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CrearActualizarCredencialRequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CreateCredentialDTORequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.CredencialRepository;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.validadores.CredentialValidator;
import edu.unicauca.SivriBackendApp.common.utilidades.CadenaAleatoria;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CredentialService {

  private final CredencialRepository credencialRepository;
  private final CredentialValidator credentialValidator;
  private final PasswordEncoder passwordEncoder;


  public Credencial createCredential(CreateCredentialDTORequest request) {

    // Codificar contraseña
    request.setPassword(passwordEncoder.encode(request.getPassword()));

    //Válida que la credencial no exista y retorna un objeto Credencial.
    Credencial newCredencial = credentialValidator.createCredential(request);

    // Crea código de seguridad que permitirá al usuario recuperar contraseña
    newCredencial.setPasswordRecoveryCode(CadenaAleatoria.generarStringAleatorio(20) + request.getUserId());
    newCredencial.setRecoverPasswordRequestedDate(LocalDate.now());

    return credencialRepository.save(newCredencial);
  }

  public void crearActualizarCredencial(CrearActualizarCredencialRequest request) {

    //Válida que la credencial exista y retorna un objeto Credencial.
    Credencial credencial = credencialRepository.findByPasswordRecoveryCode(request.getPasswordRecoveryCode()).orElseThrow();

    // Limpiar código de seguridad
    credencial.setPassword(passwordEncoder.encode(request.getPassword()));
    credencial.setPasswordRecoveryCode(null);
    credencial.setRecoverPasswordRequestedDate(null);

     credencialRepository.save(credencial);
  }

}

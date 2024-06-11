package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) utilizado para crear credenciales desde el back internamente.
 * Contiene los campos necesarios para crear una nueva credencial en el sistema.
 */
@Data
@Builder
public class CreateCredentialDTORequest {

  /**
   * El correo electrónico asociado a la nueva credencial.
   */
  private String email;

  /**
   * La contraseña asociada a la nueva credencial.
   */
  private String password;

  /**
   * El identificador único del usuario al que se vincula la nueva credencial.
   */
  private Long userId;

}

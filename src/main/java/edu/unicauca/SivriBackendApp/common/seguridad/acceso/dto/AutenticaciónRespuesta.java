package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * DTO que representa la respuesta de autenticación.
 */
@Data
@Builder
public class AutenticaciónRespuesta {

  /**
   * Token de acceso que puede ser utilizado para autorizar solicitudes.
   */
  @JsonProperty("access_token")
  private String accessToken;

  /**
   * Token de actualización que puede ser utilizado para obtener un nuevo token de acceso.
   */
  @JsonProperty("refresh_token")
  private String refreshToken;
}
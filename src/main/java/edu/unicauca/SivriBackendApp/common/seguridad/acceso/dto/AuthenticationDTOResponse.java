package edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * DTO que representa la respuesta de autenticación.
 */
@Data
@Builder
public class AuthenticationDTOResponse {

  /**
   * Token de acceso que puede ser utilizado para autorizar solicitudes.
   */
  @JsonProperty("access_token")
  private String accessToken;

  /**
   * Nombre completo del usuario autenticado
   */
  private String nombreCompleto;

  /**
   * Almacena el tipo de Usuarios
   */
  private String tipoUsuario;

  /**
   * Autoridades de usuario
   */
  private Set<String> authorities;
}
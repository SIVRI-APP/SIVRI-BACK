package edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import jakarta.persistence.*;
import lombok.*;

/**
 * Clase que representa un token en el sistema.
 */
@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

  /** Identificador único del token */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  /** Relación muchos a uno con la entidad Credential */
  @ManyToOne
  @JoinColumn(name = "credencialId")
  private Credencial credencial;

  /** Valor único del token */
  @Column(unique = true)
  private String token;

  /** Tipo de token, por defecto es 'BEARER' */
  @Enumerated(EnumType.STRING)
  private TokenType tokenType;

}

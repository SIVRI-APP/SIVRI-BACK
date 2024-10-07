package edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.Token;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Entidad con la información correspondiente a las credenciales de un usuario
 */
@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credencial implements UserDetails {

  /** Identificador único de la credencial */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credencial_seq")
  @SequenceGenerator(name = "credencial_seq", sequenceName = "credencial_seq", initialValue = 10, allocationSize = 1)
  private Integer id;

  /**
   * Relación uno a uno con la entidad Usuario.
   * Se realiza un join con la columna 'usuarioId' en la tabla 'UsuarioEntity'.
   */
  @OneToOne(optional = false)
  @JoinColumn(name = "userId")
  private UsuarioEntity user;

  /**
   * Relación uno a muchos con la entidad Token.
   * La relación se mapea por la propiedad 'credencial' en la entidad 'Token'.
   */
  @OneToMany(mappedBy = "credencial", cascade = CascadeType.ALL)
  private List<Token> tokens;

  /**
   * Correo electrónico del usuario, debe ser único y no puede ser nulo.
   */
  @Column(unique = true, nullable = false)
  private String email;

  /**
   * Contraseña del usuario, no puede ser nula y tiene una longitud máxima de 245 caracteres.
   */
  @Column(length = 245, nullable = false)
  private String password;

  /**
   * Código para la recuperación de la contraseña.
   */
  private String passwordRecoveryCode;

  /**
   * Fecha en la que se solicitó la recuperación de la contraseña.
   * Debe ser una fecha futura o presente.
   */
  @FutureOrPresent
  private LocalDate recoverPassDate;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

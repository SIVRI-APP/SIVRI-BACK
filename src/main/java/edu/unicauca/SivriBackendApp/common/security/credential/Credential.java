package edu.unicauca.SivriBackendApp.common.security.credential;

import edu.unicauca.SivriBackendApp.common.security.token.Token;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_credential")
public class Credential implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String email;
  private String password;

  @OneToMany(mappedBy = "credential")
  private List<Token> tokens;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "usuario_id", referencedColumnName = "id")
  private UsuarioEntity usuario;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return role.getAuthorities();

//    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//    authorities.add(new SimpleGrantedAuthority("docente:mentor"));
//    return authorities;
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

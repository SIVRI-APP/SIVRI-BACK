package edu.unicauca.SivriBackendApp.common.security.config;

import edu.unicauca.SivriBackendApp.common.exception.UsuarioSinCredencialesException;
import edu.unicauca.SivriBackendApp.common.security.credential.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

  private final CredentialRepository repository;

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> repository.findByEmail(username)
        .orElseThrow(() -> new UsuarioSinCredencialesException("bad.no.credentials", List.of(username)));
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

//  @Bean
//  public AuditorAware<Integer> auditorAware() {
//    return new ApplicationAuditAware();
//  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}

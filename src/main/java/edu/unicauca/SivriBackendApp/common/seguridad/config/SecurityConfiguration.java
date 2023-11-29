package edu.unicauca.SivriBackendApp.common.seguridad.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {"/v1/acceso/autenticar",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    /**
     * Configuración del filtro de seguridad para Spring Security.
     *
     * Este método define y configura el filtro de seguridad para controlar el acceso a las solicitudes HTTP.
     * La configuración incluye la desactivación de CSRF, la definición de reglas de autorización, la gestión de sesiones,
     * la provisión de un proveedor de autenticación, la adición de un filtro JWT y la configuración de la gestión de cierre de sesión.
     *
     * @param http Objeto HttpSecurity proporcionado por Spring Security para configurar las reglas de seguridad.
     * @return Una cadena de filtros de seguridad configurada.
     * @throws Exception Si ocurre una excepción al configurar el filtro de seguridad.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactivar CSRF para simplificar la configuración en este ejemplo
                .csrf(AbstractHttpConfigurer::disable)

                // Configurar reglas de autorización
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )

                // Configurar la gestión de sesiones para que sea sin estado (stateless)
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))

                // Proporcionar un proveedor de autenticación personalizado
                .authenticationProvider(authenticationProvider)

                // Agregar el filtro de autenticación JWT antes del filtro de nombre de usuario y contraseña
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)

                // Configurar la gestión de cierre de sesión
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        // Construir y devolver la cadena de filtros de seguridad configurada
        return http.build();
    }
}

package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.FuncionarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.FuncionarioRepository;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase proporciona métodos para obtener información relacionada con la identificación del usuario
 * basándose en el contexto de seguridad actual.
 *
 * @author Miguel Mosquera
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class ServicioDeIdentificaciónDeUsuario {

    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final UsuarioInfraMapper usuarioInfraMapper;

    public UsuarioEntity obtenerUsuarioEntity(){
         return usuarioRepository.findByCorreo(obtenerCorreoUsuario()).orElseThrow(
                () -> new ReglaDeNegocioException("bad.imposible.obtener.usuario.autenticado"));
    }

    public Usuario obtenerUsuario(){
        return usuarioInfraMapper.toModel(obtenerUsuarioEntity());
    }

    public FuncionarioEntity obtenerFuncionario(){
        return funcionarioRepository.findByUsuarioId(obtenerUsuario().getId()).orElseThrow(
                () -> new ReglaDeNegocioException("bad.imposible.obtener.funcionario.autenticado"));
    }

    /**
     * Obtiene los roles del usuario actual a partir del contexto de seguridad.
     *
     * @return Una lista de cadenas que representan los roles del usuario.
     */
    public List<String> obtenerRoles() {
        // Obtener el contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> userRunTimeRoles = new ArrayList<>();

        // Obtener los roles del usuario
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String rol = authority.getAuthority();
            userRunTimeRoles.add(rol);
        }

        return userRunTimeRoles;
    }

    public boolean esFuncionario() {
        List<String> roles = obtenerRoles();

        if (roles.stream().anyMatch(rol -> rol.contains("FUNCIONARIO"))){
            return true;
        }
        return false;
    }

    /**
     * Obtiene el correo de usuario actual a partir del contexto de seguridad.
     *
     * @return El nombre de usuario actual.
     */
    public String obtenerCorreoUsuario() {
        // Obtener el contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Obtener el nombre de usuario
        return authentication.getName();
    }

    public boolean perteneceAlGrupo(long grupoId){
        UsuarioEntity usuario = obtenerUsuarioEntity();
        // TODO Miguel el usuario pertenece al grupo que dice ser
        return true;
    }

    public boolean perteneceAlSemillero(long semilleroId){
        UsuarioEntity usuario = obtenerUsuarioEntity();
        // TODO Miguel el usuario pertenece al semillero que dice ser
        return true;
    }

    public boolean perteneceAlProyecto(long proyectoId){
        UsuarioEntity usuario = obtenerUsuarioEntity();
        // TODO Miguel el usuario pertenece al proyecto que dice ser
        return true;
    }
}

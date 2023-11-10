package edu.unicauca.SivriBackendApp.common.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRunTimeDetails {

    public List<String> getUserRunTimeRoles(){
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

    public String extractUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

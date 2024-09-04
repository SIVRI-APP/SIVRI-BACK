package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;

import java.util.Set;


public interface ProyectoIntegrantesProyeccion {

    // Proyecciones para las relaciones
    Set<IntegranteProyectoProyeccion> getIntegrantes();

    interface IntegranteProyectoProyeccion {
        // Define los campos necesarios de IntegranteProyectoEntity
        Integer getId();
        IntegranteUsuarioProyeccion getUsuario();
        IntegranteRolProyeccion getRolProyecto();

        interface IntegranteUsuarioProyeccion {
            Long getId();
            String getNombre();
            String getApellido();
        }
        interface IntegranteRolProyeccion {
            Integer getId();
            RolProyectoEnum getNombre();
        }
    }

}

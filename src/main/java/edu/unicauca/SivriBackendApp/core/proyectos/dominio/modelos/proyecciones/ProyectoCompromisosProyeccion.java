package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.TipoProductoEnum;

import java.util.Set;


public interface ProyectoCompromisosProyeccion {

    // Proyecciones para las relaciones
    Set<CompromisosProyeccion> getCompromisos();

    interface CompromisosProyeccion {
        Long getId();
        ProductoProyeccion getProducto();

        interface ProductoProyeccion {
            int getId();
            TipoProductoEnum getTipo();
        }
    }

}

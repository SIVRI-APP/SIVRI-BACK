package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.CategoriaProductoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoCompromisoProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.TipoProductoEnum;

import java.util.Set;


public interface ProyectoCompromisosProyeccion {

    // Proyecciones para las relaciones
    Set<CompromisosProyeccion> getCompromisos();

    interface CompromisosProyeccion {
        Long getId();
        ProductoProyeccion getProducto();
        ResponsableProyeccion getResponsable();
        Set<EvidenciasProyeccion> getEvidencias();

        interface ProductoProyeccion {
            int getId();
            TipoProductoEnum getTipo();
            CategoriaProductoEnum getCategoria();
            String getDescripcion();
        }

        interface ResponsableProyeccion {
            int getId();
            UsuarioProyeccion getUsuario();

            interface UsuarioProyeccion {
                long getId();
                String getNombre();
                String getApellido();
            }
        }

        interface EvidenciasProyeccion {
            int getId();
            EstadoCompromisoProyectoEnum getEstado();
            String getRutaAlmacenamiento();
        }
    }

}

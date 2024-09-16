package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.CategoriaProductoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.TipoProductoEnum;

public interface ProductoProyectoProyeccion {
    int getId();

    CategoriaProductoEnum getCategoria();

    TipoProductoEnum getTipo();

    String getDescripcion();
}

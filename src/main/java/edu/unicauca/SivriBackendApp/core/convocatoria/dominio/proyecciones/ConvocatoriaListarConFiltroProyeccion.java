package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;

public interface ConvocatoriaListarConFiltroProyeccion {
    Long getId();

    String getNombre();

    String getEstado();

    TipoFinanciacion getTipoFinanciacion();

}

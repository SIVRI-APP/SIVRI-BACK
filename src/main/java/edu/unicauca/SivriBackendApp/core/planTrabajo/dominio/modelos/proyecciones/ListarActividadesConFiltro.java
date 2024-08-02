package edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones;

import java.time.LocalDate;

public interface ListarActividadesConFiltro {
    Integer getId();
    //String getObjetivo();
    String getActividad();
    String getCompromiso();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    String getResponsable();
}

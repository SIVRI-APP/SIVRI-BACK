package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;

public interface ListarTodosIntegrantesConFiltro {
    String getNumeroDocumento();
    String getNombres();
    Integer getSemilleroId();
    String getNombreSemillero();
    String getRolSemillero();
    EstadoIntegranteSemillero getEstado();
    //String getNombrePrograma();
   // String getNombreFacultad();
 }

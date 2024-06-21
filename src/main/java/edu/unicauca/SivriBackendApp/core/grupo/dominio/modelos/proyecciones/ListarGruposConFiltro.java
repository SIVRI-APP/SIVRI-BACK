package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;

public interface ListarGruposConFiltro {
    int getGrupoId();
    String getGrupo();
    GrupoEstado getEstado();
    //TODO traer compromisos
    String getFacultad();
    String getDirector();

}

package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;

public interface GrupoActualizarREPO {

    Boolean actualizarPorApoyo(Grupo nuevosDatos);

    Boolean actualizarPorDirector(Grupo nuevosDatos);

    //Boolean actualizarGrupoFormuladoPorDirector(Grupo datosGrupo);

    //Boolean actualizarGrupoActivoPorDirector(Grupo datosGrupo);

}

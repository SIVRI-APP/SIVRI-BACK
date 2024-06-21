package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;

public interface GrupoCrearREPO {
    Boolean crear(Grupo nuevoGrupo);
}

package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;

public interface GrupoDisciplinaCrearREPO {
    Boolean crear(GrupoDisciplina nuevosDatos);
}

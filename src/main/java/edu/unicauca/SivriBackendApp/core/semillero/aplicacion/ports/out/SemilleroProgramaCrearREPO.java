package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;

public interface SemilleroProgramaCrearREPO {
    Boolean crear(SemilleroPrograma nuevosDatos);

}

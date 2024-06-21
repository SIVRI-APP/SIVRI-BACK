package edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

public interface LineaInvestigacionCrearREPO {
    Boolean crear(LineaInvestigacion nuevaLinea);

}

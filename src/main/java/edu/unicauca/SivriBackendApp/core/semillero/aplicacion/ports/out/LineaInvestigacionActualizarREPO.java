package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

public interface LineaInvestigacionActualizarREPO {
    Boolean actualizarLinea(LineaInvestigacion nuevaLinea);
}

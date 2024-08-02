package edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out;


import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;

public interface LineaInvestigacionEliminarREPO {
    Boolean eliminadoFisico(LineaInvestigacion lineaEliminar);
    Boolean eliminadoFisicoLinea(int id);
}

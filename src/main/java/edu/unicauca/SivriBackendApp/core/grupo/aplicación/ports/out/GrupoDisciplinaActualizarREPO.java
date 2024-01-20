package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;

public interface GrupoDisciplinaActualizarREPO {
    Boolean actualizar(GrupoDisciplina nuevoDatos);
}

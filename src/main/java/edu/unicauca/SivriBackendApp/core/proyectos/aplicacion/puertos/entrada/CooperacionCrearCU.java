package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;

public interface CooperacionCrearCU {

    void crearCooperacion(Proyecto proyecto, OrganismoDeInvestigacion organismoDeInvestigacion, boolean isPrincipal);

}

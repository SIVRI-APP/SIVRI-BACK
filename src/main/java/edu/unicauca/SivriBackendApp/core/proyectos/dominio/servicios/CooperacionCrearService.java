package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.CooperacionCrearCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.CooperacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Cooperacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.validadores.CooperacionValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CooperacionCrearService implements CooperacionCrearCU {

    private final CooperacionCrearREPO cooperacionCrearREPO;
    private final CooperacionValidator cooperacionValidator;

    @Override
    public void crearCooperacion(Proyecto proyecto, OrganismoDeInvestigacion organismoDeInvestigacion, boolean isPrincipal) {

        // Validaciones
        cooperacionValidator.crearCooperacion(proyecto, organismoDeInvestigacion, isPrincipal);

        Cooperacion cooperacion = new Cooperacion();
        cooperacion.setProyecto(proyecto);
        cooperacion.setPrincipal(isPrincipal);
        cooperacion.setFechaInicio(LocalDate.now());
        cooperacion.setEstado(true);
        // todo miguel setear organismo cuando yurani de el servicio

        cooperacionCrearREPO.crear(cooperacion);
    }
}

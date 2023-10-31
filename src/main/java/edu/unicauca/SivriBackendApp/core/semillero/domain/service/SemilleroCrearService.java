package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.*;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.SemilleroCrearREPO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SemilleroCrearService implements SemilleroCrearCU {

    private final SemilleroCrearREPO semilleroCrearREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;
    private final IntegranteSemilleroCrearCU integranteSemilleroCrearCU;

    public SemilleroCrearService(SemilleroCrearREPO semilleroCrearREPO, SemilleroObtenerCU semilleroObtenerCU, IntegranteSemilleroCrearCU integranteSemilleroCrearCU) {
        this.semilleroCrearREPO = semilleroCrearREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
        this.integranteSemilleroCrearCU = integranteSemilleroCrearCU;
    }

    @Override
    public Respuesta<Boolean> crear(Semillero semillero, String mentorId) {
        System.out.println("DATOS que recive el service del semillero nuevo: "+semillero+"nombre "+semillero.getNombre() );
        System.out.println("mentorid "+mentorId);
        Boolean existe= semilleroObtenerCU.existePorNombre(semillero.getNombre()).getData();
        System.out.println("existe nombre "+existe);
        Grupo grupo=new Grupo();
        grupo.setGrupoId(semillero.getGrupoId());
        semillero.setGrupoId(grupo.getGrupoId());
        semillero.setEstado(SemilleroEstado.FORMULADO);
        semillero.setFechaCreacion(LocalDate.now());
        //obj para crear el mentor y que lo guarde en la bd
        IntegranteSemillero objIntegrante=new IntegranteSemillero();
        objIntegrante.setNumeroDocumento(mentorId);
        RolSemillero rol=new RolSemillero();
        rol.setId(1);
        objIntegrante.setRolSemillero(rol);
        objIntegrante.setEstado(EstadoIntegranteSemillero.ACTIVO);
        objIntegrante.setSemestre("n.a");
        objIntegrante.setFechaIngreso(LocalDate.now());
        System.out.println("datos del mentor a registrar "+objIntegrante);

        Boolean respuesta = semilleroCrearREPO.crear(semillero,objIntegrante);
        System.out.println("respuesta del service "+respuesta);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacionSemilleroIntegrante.objeto", List.of("Semillero", "Id", String.valueOf(semillero.getId()),"Mentor ","Id",String.valueOf(objIntegrante.getId())));
        }
        return new RespuestaHandler<>(201,"success.creacionSemilleroMentor.objeto", List.of("Semillero","Mentor"),"",true).getRespuesta();

    }

}

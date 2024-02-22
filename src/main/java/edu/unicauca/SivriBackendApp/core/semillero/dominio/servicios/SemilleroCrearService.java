package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.SemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioObtenerCU;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class SemilleroCrearService implements SemilleroCrearCU {

    private final SemilleroCrearREPO semilleroCrearREPO;
    private final SemilleroObtenerCU semilleroObtenerCU;
    private final GrupoObtenerCU grupoObtenerCU;
    private final IntegranteSemilleroCrearCU integranteSemilleroCrearCU;
    private final UsuarioObtenerCU usuarioObtenerCU;

    public SemilleroCrearService(SemilleroCrearREPO semilleroCrearREPO, SemilleroObtenerCU semilleroObtenerCU, GrupoObtenerCU grupoObtenerCU, IntegranteSemilleroCrearCU integranteSemilleroCrearCU, UsuarioObtenerCU usuarioObtenerCU) {
        this.semilleroCrearREPO = semilleroCrearREPO;
        this.semilleroObtenerCU = semilleroObtenerCU;
        this.grupoObtenerCU = grupoObtenerCU;
        this.integranteSemilleroCrearCU = integranteSemilleroCrearCU;
        this.usuarioObtenerCU = usuarioObtenerCU;
    }

    @Transactional
    @Override
    public Respuesta<Boolean> crear(Semillero semillero, int mentorId) {
        System.out.println("DATOS que recive el service del semillero nuevo: "+semillero+"nombre "+semillero.getNombre() );
        System.out.println("mentorid "+mentorId);
        semilleroObtenerCU.existePorNombre(semillero.getNombre()).getData();
        grupoObtenerCU.existePorId(semillero.getGrupoId());
        //el mentor asignado se encuentra en la bd de usuarios

        semillero.setEstado(SemilleroEstado.FORMULADO);
        semillero.setFechaCreacion(LocalDate.now());

        //debo llamar el caso de uso de crear el integrante

        Semillero semilleroCreado = semilleroCrearREPO.crear(semillero);

        /*if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacionSemilleroIntegrante.objeto", List.of("Semillero", "Id", String.valueOf(semillero.getId())*//*,"Mentor ","Id",String.valueOf(objIntegrante.getId()*//*));
        }*/
        return new RespuestaHandler<>(201,"success.creacionSemilleroMentor.objeto", List.of("Semillero","Mentor"),"",true).getRespuesta();

    }

}

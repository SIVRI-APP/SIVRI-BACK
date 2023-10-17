package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.IntegranteGrupoCrearREPO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Component
public class IntegranteGrupoCrearService implements IntegranteGrupoCrearCU {

    private final IntegranteGrupoCrearREPO integranteGrupoCrearREPO;
    private final RolesGrupoObtenerCU rolesGrupoObtenerCU;
    private final GrupoObtenerCU grupoObtenerCU;

    public IntegranteGrupoCrearService(IntegranteGrupoCrearREPO integranteGrupoCrearREPO, RolesGrupoObtenerCU rolesGrupoObtenerCU, GrupoObtenerCU grupoObtenerCU) {
        this.integranteGrupoCrearREPO = integranteGrupoCrearREPO;
        this.rolesGrupoObtenerCU = rolesGrupoObtenerCU;
        this.grupoObtenerCU = grupoObtenerCU;
    }
    @Transactional
    @Override
    public Respuesta<Boolean> asociarIntegranteGrupo(IntegranteGrupo nuevosDatos) {
        //System.out.println("ingreso al service de asociar grupo");
       // System.out.println(" que datosd trae: "+grupoObtenerCU.existePorId(nuevosDatos.getGrupo().getGrupoId()));
        rolesGrupoObtenerCU.existePorId(nuevosDatos.getRolGrupo().getId());
        nuevosDatos.setEstado(EstadoIntegranteGrupo.ACTIVO);
        nuevosDatos.setFechaInicio(LocalDate.now());
        //System.out.println("datos que se enviar desde el service al asociar integrante del repo: "+nuevosDatos);
        Boolean respuesta=integranteGrupoCrearREPO.asociarIntegranteGrupo(nuevosDatos);
        //System.out.println("RESPUESTA "+respuesta);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Integrante Grupo", "Id", String.valueOf(nuevosDatos.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Integrante Grupo"), "", true).getRespuesta();
    }
}

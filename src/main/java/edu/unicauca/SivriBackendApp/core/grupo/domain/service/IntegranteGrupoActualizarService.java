package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.IntegranteGrupoActualizarREPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IntegranteGrupoActualizarService implements IntegranteGrupoActualizarCU {
    private final IntegranteGrupoActualizarREPO integranteGrupoActualizarREPO;
    private final IntegranteGrupoObtenerCU integranteGrupoObtenerCU;
    private final RolesGrupoObtenerCU rolesGrupoObtenerCU;

    public IntegranteGrupoActualizarService(IntegranteGrupoActualizarREPO integranteGrupoActualizarREPO, IntegranteGrupoObtenerCU integranteGrupoObtenerCU, RolesGrupoObtenerCU rolesGrupoObtenerCU) {
        this.integranteGrupoActualizarREPO = integranteGrupoActualizarREPO;
        this.integranteGrupoObtenerCU = integranteGrupoObtenerCU;
        this.rolesGrupoObtenerCU = rolesGrupoObtenerCU;
    }

    @Override
    public Respuesta<Boolean> actualizar(IntegranteGrupo nuevosDatos) {
        //System.out.println("DAOTS QUE LLEGAN A SERVICE: "+nuevosDatos);
        IntegranteGrupo objParaActualizar=integranteGrupoObtenerCU.obtenerIntegrantePorId(nuevosDatos.getId()).getData();
        //System.out.println("id grupo "+objParaActualizar.getGrupo().getId());

        //System.out.println("DATOS en DB DE INTEGRANTE obtenido por cu "+objParaActualizar);
        rolesGrupoObtenerCU.existePorId(nuevosDatos.getRolGrupo().getId());

        objParaActualizar.getRolGrupo().setId(nuevosDatos.getRolGrupo().getId());

        objParaActualizar.setEstado(nuevosDatos.getEstado());
        objParaActualizar.setFechaFin(nuevosDatos.getFechaFin());
        boolean respuesta=integranteGrupoActualizarREPO.actualizar(objParaActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Integrante Grupo", "Id", String.valueOf(nuevosDatos.getId())));
        }

        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("IntegranteGrupo"), "", true).getRespuesta();
    }
}

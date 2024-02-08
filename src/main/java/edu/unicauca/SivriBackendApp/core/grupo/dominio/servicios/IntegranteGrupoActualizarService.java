package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.IntegranteGrupoActualizarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
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

        IntegranteGrupo objParaActualizar=integranteGrupoObtenerCU.obtenerIntegrantePorId(nuevosDatos.getId()).getData();
        Grupo grupo= objParaActualizar.getGrupo();
        objParaActualizar.getGrupo().setGrupoId(grupo.getId());

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

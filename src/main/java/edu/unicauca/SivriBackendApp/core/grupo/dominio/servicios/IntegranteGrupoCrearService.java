package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.IntegranteGrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
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
        // TODO validar si el integrante existe en ususarios
        rolesGrupoObtenerCU.existePorId(nuevosDatos.getRolGrupo().getId());
        nuevosDatos.setEstado(EstadoIntegranteGrupo.ACTIVO);
        nuevosDatos.setFechaInicio(LocalDate.now());
        Boolean respuesta=integranteGrupoCrearREPO.asociarIntegranteGrupo(nuevosDatos);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Integrante Grupo", "Id", String.valueOf(nuevosDatos.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Integrante Grupo"), "", true).getRespuesta();
    }
}

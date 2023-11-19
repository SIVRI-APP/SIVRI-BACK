package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.GrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.IntegranteGrupoCrearREPO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class GrupoCrearService implements GrupoCrearCU {

    private final GrupoCrearREPO grupoCrearREPO;
    private final GrupoObtenerCU grupoObtenerCU;
   // private final IntegranteGrupoCrearREPO integranteGrupoCrearREPO;

    public GrupoCrearService(GrupoCrearREPO grupoCrearREPO, IntegranteGrupoCrearREPO integranteGrupoCrearREPO, GrupoObtenerCU grupoObtenerCU) {
        this.grupoCrearREPO = grupoCrearREPO;
      //  this.integranteGrupoCrearREPO = integranteGrupoCrearREPO;
        this.grupoObtenerCU = grupoObtenerCU;
    }
    @Transactional
    @Override
    public Respuesta<Boolean> crear(Grupo nuevoGrupo) {
      //  System.out.println("datos que llegan: "+nuevoGrupo);
        grupoObtenerCU.existePorNombre(nuevoGrupo.getNombre());
        nuevoGrupo.setEstado(GrupoEstado.FORMULADO);
        Boolean respuesta=grupoCrearREPO.crear(nuevoGrupo);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Grupo", "Id", String.valueOf(nuevoGrupo.getId())));
        }
        return new RespuestaHandler<>(201,"success.creacion.objeto", List.of("Grupo"),"",true).getRespuesta();
    }
}

package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.IntegranteGrupoCrearREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class GrupoCrearService implements GrupoCrearCU {

    private final GrupoCrearREPO grupoCrearREPO;
    private final GrupoObtenerCU grupoObtenerCU;
    private final UsuarioObtenerCU usuarioObtenerCU;
   // private final IntegranteGrupoCrearREPO integranteGrupoCrearREPO;

    public GrupoCrearService(GrupoCrearREPO grupoCrearREPO, IntegranteGrupoCrearREPO integranteGrupoCrearREPO, GrupoObtenerCU grupoObtenerCU, UsuarioObtenerCU usuarioObtenerCU) {
        this.grupoCrearREPO = grupoCrearREPO;
      //  this.integranteGrupoCrearREPO = integranteGrupoCrearREPO;
        this.grupoObtenerCU = grupoObtenerCU;
        this.usuarioObtenerCU = usuarioObtenerCU;
    }
    @Transactional
    @Override
    public Respuesta<Boolean> crear(Grupo nuevoGrupo) {
        //System.out.println("datos que llegan al service: "+nuevoGrupo);
        grupoObtenerCU.existePorNombre(nuevoGrupo.getNombre());
        nuevoGrupo.setEstado(GrupoEstado.FORMULADO);
        Boolean respuesta=grupoCrearREPO.crear(nuevoGrupo);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Grupo", "Id", String.valueOf(nuevoGrupo.getId())));
        }
        return new RespuestaHandler<>(201,"success.creacion.objeto", List.of("Grupo"),"",true).getRespuesta();
    }
}

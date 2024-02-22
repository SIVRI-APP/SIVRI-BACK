package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.IntegranteSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class IntegranteSemilleroCrearService implements IntegranteSemilleroCrearCU {
    private final IntegranteSemilleroCrearREPO integranteSemilleroCrearREPO;
    private final RolesSemilleroObtenerCU rolesSemilleroObtenerCU;
    private final UsuarioObtenerCU usuarioObtenerCU;
    private final SemilleroObtenerCU semilleroObtenerCU;

    public IntegranteSemilleroCrearService(IntegranteSemilleroCrearREPO integranteSemilleroCrearREPO, RolesSemilleroObtenerCU rolesSemilleroObtenerCU, UsuarioObtenerCU usuarioObtenerCU, SemilleroObtenerCU semilleroObtenerCU) {
        this.integranteSemilleroCrearREPO = integranteSemilleroCrearREPO;
        this.rolesSemilleroObtenerCU = rolesSemilleroObtenerCU;
        this.usuarioObtenerCU = usuarioObtenerCU;
        this.semilleroObtenerCU = semilleroObtenerCU;
    }
    @Transactional(readOnly = false)
    @Override
    public Respuesta<Boolean> crear(IntegranteSemillero nuevosIntegranteSemillero) {
        nuevosIntegranteSemillero.getSemillero().setId(nuevosIntegranteSemillero.getSemillero().getSemilleroId());

        semilleroObtenerCU.existePorId(nuevosIntegranteSemillero.getSemillero().getSemilleroId());

        rolesSemilleroObtenerCU.existePorId(nuevosIntegranteSemillero.getRolSemillero().getId());
//TODO FALTA ARREGLAR LO DE USUARIO
       // usuarioObtenerCU.existsByTipoDocumentoAndNumeroDocumento(nuevosIntegranteSemillero.getUsuario().getTipoDocumento(),nuevosIntegranteSemillero.getUsuario().getNumeroDocumento());
        //InformacionDetalladaUsuario usuarioObt=usuarioObtenerCU.validarExistenciaUsuarioSistema(nuevosIntegranteSemillero.getUsuario().getTipoDocumento().toString(),nuevosIntegranteSemillero.getUsuario().getNumeroDocumento()).getData();

        Usuario usuario=new Usuario();
        //usuario.setId(usuarioObt.getId());

        nuevosIntegranteSemillero.setUsuario(usuario);
        nuevosIntegranteSemillero.setEstado(EstadoIntegranteSemillero.ACTIVO);
        nuevosIntegranteSemillero.setFechaIngreso(LocalDate.now());

        Boolean respuesta=integranteSemilleroCrearREPO.crear(nuevosIntegranteSemillero);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Integrante Semillero", "Id", String.valueOf(nuevosIntegranteSemillero.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Integrante Semillero"), "", true).getRespuesta();
    }

}

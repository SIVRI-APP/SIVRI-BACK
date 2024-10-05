package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.IntegranteSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class IntegranteSemilleroCrearService implements IntegranteSemilleroCrearCU {
    private final IntegranteSemilleroCrearREPO integranteSemilleroCrearREPO;
    private final RolesSemilleroObtenerCU rolesSemilleroObtenerCU;
    private final UsuarioObtenerCU usuarioObtenerCU;
    private final SemilleroObtenerCU semilleroObtenerCU;

    @Transactional(readOnly = false)
    @Override
    public Respuesta<Boolean> crear(IntegranteSemillero nuevosIntegranteSemillero) {

        nuevosIntegranteSemillero.getSemillero().setId(nuevosIntegranteSemillero.getSemillero().getSemillero_Id());
        semilleroObtenerCU.existePorId(nuevosIntegranteSemillero.getSemillero().getSemillero_Id());
        rolesSemilleroObtenerCU.existePorId(nuevosIntegranteSemillero.getRolSemillero().getId());
        nuevosIntegranteSemillero.setEstado(EstadoIntegranteSemillero.ACTIVO);
        nuevosIntegranteSemillero.setFechaIngreso(LocalDate.now());

        Boolean respuesta=integranteSemilleroCrearREPO.crear(nuevosIntegranteSemillero);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.creacion.objeto", List.of("Integrante Semillero", "Id", String.valueOf(nuevosIntegranteSemillero.getId())));
        }
        return new RespuestaHandler<>(201, "success.creacion.objeto", List.of("Integrante Semillero"), "", true).getRespuesta();
    }

}

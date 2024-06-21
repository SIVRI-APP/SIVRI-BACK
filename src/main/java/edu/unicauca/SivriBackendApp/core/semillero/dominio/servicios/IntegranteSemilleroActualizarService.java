package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.IntegranteSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
@Component
public class IntegranteSemilleroActualizarService implements IntegranteSemilleroActualizarCU {
    private final IntegranteSemilleroActualizarREPO integranteSemilleroActualizarREPO;
    private final IntegranteSemilleroObtenerCU integranteSemilleroObtenerCU;
    private final RolesSemilleroObtenerCU rolesSemilleroObtenerCU;

    public IntegranteSemilleroActualizarService(IntegranteSemilleroActualizarREPO integranteSemilleroActualizarREPO, IntegranteSemilleroObtenerCU integranteSemilleroObtenerCU, RolesSemilleroObtenerCU rolesSemilleroObtenerCU) {
        this.integranteSemilleroActualizarREPO = integranteSemilleroActualizarREPO;
        this.integranteSemilleroObtenerCU = integranteSemilleroObtenerCU;
        this.rolesSemilleroObtenerCU = rolesSemilleroObtenerCU;
}

    @Override
    public Respuesta<Boolean> actualizar(IntegranteSemillero nuevosDatosIntegrante) {
        IntegranteSemillero objIntegranteActualizar=integranteSemilleroObtenerCU.obtenerPorId(nuevosDatosIntegrante.getId()).getData();

        objIntegranteActualizar.setEstado(nuevosDatosIntegrante.getEstado());
        if (nuevosDatosIntegrante.getEstado().equals(EstadoIntegranteSemillero.INACTIVO)  ){
            objIntegranteActualizar.setFechaRetiro(LocalDate.now());
        }else {
            objIntegranteActualizar.setFechaRetiro(nuevosDatosIntegrante.getFechaRetiro());
        }
        rolesSemilleroObtenerCU.existePorId(nuevosDatosIntegrante.getRolSemillero().getId());
        objIntegranteActualizar.getRolSemillero().setId(nuevosDatosIntegrante.getRolSemillero().getId());

        Boolean respuesta=integranteSemilleroActualizarREPO.actualizar(objIntegranteActualizar);

        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Integrante Semillero", "Id", String.valueOf(nuevosDatosIntegrante.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Integrante Semillero"), "", true).getRespuesta();
    }

}

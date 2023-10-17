package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroActualizarREPO;
import org.springframework.stereotype.Component;

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
        //System.out.println("DATOS QUE LLEGAN AL SERVICE "+nuevosDatosIntegrante);
        IntegranteSemillero objIntegranteActualizar=integranteSemilleroObtenerCU.obtenerPorId(nuevosDatosIntegrante.getId()).getData();
        //System.out.println("OBJ INTEGRANTE CAPTURADO "+objIntegranteActualizar);
        objIntegranteActualizar.setEstado(nuevosDatosIntegrante.getEstado());
        objIntegranteActualizar.setSemestre(nuevosDatosIntegrante.getSemestre());
        objIntegranteActualizar.setFechaRetiro(nuevosDatosIntegrante.getFechaRetiro());

        rolesSemilleroObtenerCU.existePorId(nuevosDatosIntegrante.getRolSemillero().getId());
        objIntegranteActualizar.getRolSemillero().setId(nuevosDatosIntegrante.getRolSemillero().getId());

        //System.out.println("obj integrante actualizado en el service "+objIntegranteActualizar);
        Boolean respuesta=integranteSemilleroActualizarREPO.actualizar(objIntegranteActualizar);
        //System.out.println("RESPUESTA SERVICE "+respuesta);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.error.actualizacion.objeto", List.of("Integrante Semillero", "Id", String.valueOf(nuevosDatosIntegrante.getId())));
        }
        return new RespuestaHandler<>(200, "success.actualizacion.objeto", List.of("Integrante Semillero"), "", true).getRespuesta();
    }

}

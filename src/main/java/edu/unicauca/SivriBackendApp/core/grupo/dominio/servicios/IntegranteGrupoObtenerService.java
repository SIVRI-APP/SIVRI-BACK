package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.IntegranteGrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesConFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Component
public class IntegranteGrupoObtenerService implements IntegranteGrupoObtenerCU {

    private final IntegranteGrupoObtenerREPO integranteGrupoObtenerREPO;

    public IntegranteGrupoObtenerService(IntegranteGrupoObtenerREPO integranteGrupoObtenerREPO) {
        this.integranteGrupoObtenerREPO = integranteGrupoObtenerREPO;
    }

    @Override
    public Respuesta<IntegranteGrupo> obtenerIntegrantePorId(int id) {
        Optional<IntegranteGrupo> respuestaBd=integranteGrupoObtenerREPO.obtenerIntegranteGrupoPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("IntegranteGrupo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd.get()).getRespuesta();

    }

    @Override
    public Respuesta<List<IntegranteGrupo>> obtenerIntegrantesGrupo() {
        List<IntegranteGrupo> respuestaBd=integranteGrupoObtenerREPO.obtenerIntegrantesGrupo();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();

    }

    @Override
    public Respuesta<Page<List<ListarIntegrantesConFiltro>>> listarIntegrantesConFiltro(int pageNo, int pageSize, String numeroDocumento, LocalDate fechaIngresoo, LocalDate fechaRetiro, Integer idGrupo, String nombreGrupo, String rolGrupo, EstadoIntegranteGrupo estado) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<List<ListarIntegrantesConFiltro>> respuestaBd =integranteGrupoObtenerREPO.listarIntegrantesConFiltro(pageable,numeroDocumento, fechaIngresoo, fechaRetiro,idGrupo,nombreGrupo,rolGrupo, estado);
        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }


}

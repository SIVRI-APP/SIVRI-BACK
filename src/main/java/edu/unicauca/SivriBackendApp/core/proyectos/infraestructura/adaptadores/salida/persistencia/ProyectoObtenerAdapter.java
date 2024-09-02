package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.EvidenciasDocumentosConvocatoriaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoInformacionDetalladaDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapperStruct;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class ProyectoObtenerAdapter implements ProyectoObtenerREPO {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoInfraMapperStruct proyectoInfraMapperStruct;

    @Override
    public Optional<ProyectoInformacionDetalladaDTO> obtenerProyectoInformacionDetallada(long proyectoId) {
        ProyectoInformacionDetalladaProyeccion r1 = proyectoRepository.obtenerProyectoInformacionDetallada1(proyectoId).get();
        Set<EvidenciasDocumentosConvocatoriaProyeccion> r2 = proyectoRepository.obtenerProyectoInformacionDetallada2(proyectoId);

        ProyectoInformacionDetalladaDTO resultado = new ProyectoInformacionDetalladaDTO();
        resultado.setInformacionDetallada(r1);
        resultado.setEvidenciasDocumentosConvocatoria(r2);

        return Optional.of(resultado);
    }

    @Override
    public Page<ProyectoListarConFiltroProyeccion> listarConFiltro(Pageable page, String id, String nombre, EstadoProyecto estado, LocalDate fechaInicio, LocalDate fechaFin, Integer organismoDeInvestigacionId, TipoFinanciacion tipoFinanciacion, Long usuarioAutenticadoId) {

        String estadoString = (estado != null) ? estado.toString() : null;
        String fechaInicioString = (fechaInicio != null) ? fechaInicio.toString() : null;
        String fechaFinString = (fechaFin != null) ? fechaFin.toString() : null;
        String tipoFinanciacionString = (tipoFinanciacion != null) ? tipoFinanciacion.toString() : null;


        return proyectoRepository.listarConFiltro(id, nombre, estadoString, fechaInicioString, fechaFinString, organismoDeInvestigacionId, tipoFinanciacionString, usuarioAutenticadoId, page);
    }

    @Override
    public Optional<Proyecto> obtenerProyecto(long proyectoId) {
        Optional<Proyecto> respuesta = Optional.empty();
        Optional<ProyectoEntity> respuestaBD = proyectoRepository.findById(proyectoId);

        if (respuestaBD.isPresent()){
            respuesta = Optional.of(proyectoInfraMapperStruct.toDto(respuestaBD.get()));
        }

        return respuesta;
    }
}

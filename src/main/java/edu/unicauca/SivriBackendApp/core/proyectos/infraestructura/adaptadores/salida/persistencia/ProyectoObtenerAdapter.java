package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.*;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapperStruct;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProyectoObtenerAdapter implements ProyectoObtenerREPO {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoInfraMapperStruct proyectoInfraMapperStruct;

    @Override
    public Page<ListarOrganismosParaAsociarProyectoProyeccion> listarSimpleConFiltro(Pageable page, Integer id, String nombre, Long usuarioAutenticadoId) {
        return proyectoRepository.listarSimpleConFiltro(id, nombre, usuarioAutenticadoId, page);
    }

    @Override
    public Optional<ProyectoDetalladoDTO> obtenerProyectoInformacionDetallada(long proyectoId) {

        ProyectoInformacionDetalladaProyeccion proyectoInformacionDetallada = proyectoRepository.obtenerProyectoInformacionDetallada1(proyectoId).orElse(null);
        ProyectoConvocatoriaProyeccion proyectoConvocatoria = proyectoRepository.obtenerProyectoInformacionDetallada2(proyectoId).orElse(null);
        ProyectoEvidenciasDocumentosProyeccion proyectoEvidenciasDocumentosConvocatoria = proyectoRepository.obtenerProyectoInformacionDetallada3(proyectoId).orElse(null);
        ProyectoIntegrantesProyeccion proyectoIntegrantes = proyectoRepository.obtenerProyectoInformacionDetalladaIntegrantes(proyectoId).orElse(null);
        ProyectoCompromisosProyeccion proyectoCompormisos = proyectoRepository.obtenerProyectoInformacionDetalladaCompromisos(proyectoId).orElse(null);



        ProyectoDetalladoDTO resultado = new ProyectoDetalladoDTO();
        resultado.setInformacionDetalladaProyecto(proyectoInformacionDetallada);
        resultado.setConvocatoriaProyecto(proyectoConvocatoria);
        resultado.setEvidenciasDocumentosProyecto(proyectoEvidenciasDocumentosConvocatoria);
        resultado.setIntegrantesProyecto(proyectoIntegrantes);
        resultado.setCompromisosProyecto(proyectoCompormisos);

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

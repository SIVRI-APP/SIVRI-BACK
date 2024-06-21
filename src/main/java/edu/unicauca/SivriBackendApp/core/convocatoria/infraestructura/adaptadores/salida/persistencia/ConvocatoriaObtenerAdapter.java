package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ConvocatoriaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.ConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper.ConvocatoriaInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ConvocatoriaObtenerAdapter implements ConvocatoriaObtenerREPO {

    private final ConvocatoriaRepository convocatoriaRepository;

    private final ConvocatoriaInfraMapper convocatoriaInfraMapper;

    @Override
    public Optional<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(long convocatoriaId) {
        return convocatoriaRepository.obtenerConvocatoriaInformacionDetallada(convocatoriaId);
    }

    @Override
    public Page<ConvocatoriaListarConFiltroProyeccion> listarConFiltro(Pageable page, String id, String nombre, ConvocatoriaEstado estado, TipoFinanciacion tipoFinanciacion) {
        String estadoString = (estado != null) ? estado.toString() : null;
        String tipoFinanciacionString = (tipoFinanciacion != null) ? tipoFinanciacion.toString() : null;

        return convocatoriaRepository.listarConFiltro(id, nombre, estadoString, tipoFinanciacionString, page);
    }

    @Override
    public Optional<Convocatoria> obtenerConvocatoria(long convocatoriaId) {
        Optional<Convocatoria> respuesta = Optional.empty();
        Optional<ConvocatoriaEntity> respuestaBD = convocatoriaRepository.findById(convocatoriaId);

        if (respuestaBD.isPresent()){
            respuesta = Optional.of(convocatoriaInfraMapper.toDto(respuestaBD.get()));
        }

        return respuesta;
    }
}

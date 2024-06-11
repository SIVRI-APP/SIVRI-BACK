package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ConvocatoriaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ConvocatoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ConvocatoriaObtenerAdapter implements ConvocatoriaObtenerREPO {

    private final ConvocatoriaRepository convocatoriaRepository;

    @Override
    public Optional<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(long convocatoriaId) {
        return convocatoriaRepository.obtenerConvocatoriaInformacionDetallada(convocatoriaId);
    }
}

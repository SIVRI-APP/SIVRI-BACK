package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.proyecciones.ProyectoListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapperStruct;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProyectoObtenerAdapter implements ProyectoObtenerREPO {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoInfraMapperStruct proyectoInfraMapperStruct;

    @Override
    public Optional<ProyectoInformacionDetalladaProyeccion> obtenerProyectoInformacionDetallada(long proyectoId) {
        return proyectoRepository.obtenerProyectoInformacionDetallada(proyectoId);
    }

    @Override
    public Page<ProyectoListarConFiltroProyeccion> listarConFiltro(Pageable page, String id, String nombre) {

        return proyectoRepository.listarConFiltro(id, nombre, page);
    }

    @Override
    public Optional<Proyecto> obtenerProyecto(long proyectoId) {
        Optional<ProyectoEntity> proyecto = proyectoRepository.findById(proyectoId);

        return proyecto.map(proyectoInfraMapperStruct::toDto);
    }
}

package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.CompromisoREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.PrepararAgregarCompromisoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.CompromisoProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.CompromisoProyectoRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.IntegranteRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProductoProyectoRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.ProyectoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompromisoAdapter implements CompromisoREPO {

    private final ProyectoRepository proyectoRepository;
    private final ProductoProyectoRepository productoProyectoRepository;
    private final CompromisoProyectoRepository compromisoProyectoRepository;
    private final IntegranteRepository integranteRepository;
    private final ProyectoInfraMapper proyectoInfraMapper;

    @Override
    public PrepararAgregarCompromisoDTO prepararAgregarCompromiso(long proyectoId) {
        PrepararAgregarCompromisoDTO respuesta = new PrepararAgregarCompromisoDTO();

        respuesta.setIntegrantesProyecto(proyectoRepository.obtenerProyectoInformacionDetalladaIntegrantes(proyectoId).get());
        respuesta.setProductos(productoProyectoRepository.findAll());
        return respuesta;
    }

    @Override
    public Boolean agregarCompromiso(Proyecto proyecto, long integranteId, int productoEnumId) {
        CompromisoProyectoEntity compromisoProyecto = new CompromisoProyectoEntity();
        compromisoProyecto.setProyecto(proyectoInfraMapper.fromModelToEntityUsingIdOnly(proyecto.getId()));
        compromisoProyecto.setProducto(productoProyectoRepository.findById(productoEnumId).get());
        compromisoProyecto.setResponsable(integranteRepository.findById(integranteId).get());

        compromisoProyectoRepository.save(compromisoProyecto);
        return true;
    }
}

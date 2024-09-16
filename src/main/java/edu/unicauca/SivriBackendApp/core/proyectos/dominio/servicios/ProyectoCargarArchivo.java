package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad.DocumentoConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.DocumentoConvocatoriaRepository;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoCompromisoProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.CompromisoAdapter;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.EvidenciaProyectoDocumentoConvocatoriaAdapter;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaCompromisoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaProyectoDocumentoConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.ProyectoInfraMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProyectoCargarArchivo {
    /**
     * Adaptadores
     */
    private final EvidenciaProyectoDocumentoConvocatoriaAdapter evidenciaProyectoDocumentoConvocatoriaAdapter;
    private final DocumentoConvocatoriaRepository documentoConvocatoriaRepository;
    private final CompromisoAdapter compromisoAdapter;

    /**
     * Servicios
     */
    private final ProyectoObtenerCU proyectoObtenerCU;
    private final ProyectoInfraMapper proyectoInfraMapper;


    @Transactional
    public Respuesta<EvidenciaProyectoDocumentoConvocatoriaEntity> cargarDocumentoConvocatoria(String nombre, String organismoId, String documentoConvocatoriaId) {

        ProyectoEntity proyecto = proyectoInfraMapper.fromModelToEntityUsingIdOnly(proyectoObtenerCU.obtenerProyecto(Long.parseLong(organismoId)).getData().getId());

        Optional<DocumentoConvocatoriaEntity> documentoConvocatoria = documentoConvocatoriaRepository.findById(Long.valueOf(documentoConvocatoriaId));
        if (documentoConvocatoria.isEmpty()){
            throw new ReglaDeNegocioException("bad.documentoConvocatoriaNoExiste", List.of(documentoConvocatoriaId));
        }

        EvidenciaProyectoDocumentoConvocatoriaEntity evidencia = new EvidenciaProyectoDocumentoConvocatoriaEntity();
        evidencia.setProyecto(proyecto);
        evidencia.setDocumentoConvocatoria(documentoConvocatoria.get());
        evidencia.setNombre(nombre);

        return new RespuestaHandler<>(200, "ok", "", evidenciaProyectoDocumentoConvocatoriaAdapter.guardar(evidencia)).getRespuesta();
    }

    @Transactional
    public Respuesta<EvidenciaCompromisoEntity> cargarDocumentoCompromiso(String nombre, String organismoId, String documentoConvocatoriaId) {

        EvidenciaCompromisoEntity evidencia = new EvidenciaCompromisoEntity();
        evidencia.setCompromisoProyecto(null);
        evidencia.setRutaAlmacenamiento(null);
        evidencia.setEstado(EstadoCompromisoProyectoEnum.REVISION_VRI);

        return new RespuestaHandler<>(200, "ok", "", compromisoAdapter.agregarEvidenciaCompromiso(evidencia)).getRespuesta();
    }

}

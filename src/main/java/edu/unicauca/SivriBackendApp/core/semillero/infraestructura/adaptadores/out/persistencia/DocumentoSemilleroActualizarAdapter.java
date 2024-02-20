package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.DocumentoSemilleroActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.DocumentoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IDocumentoSemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class DocumentoSemilleroActualizarAdapter implements DocumentoSemilleroActualizarREPO {

    private final IDocumentoSemilleroRepository documentoSemilleroRepository;
    private final DocumentoSemilleroMapper documentoSemilleroMapper;

    public DocumentoSemilleroActualizarAdapter(IDocumentoSemilleroRepository documentoSemilleroRepository, DocumentoSemilleroMapper documentoSemilleroMapper) {
        this.documentoSemilleroRepository = documentoSemilleroRepository;
        this.documentoSemilleroMapper = documentoSemilleroMapper;
    }

    @Override
    public Boolean actualizar(DocumentoSemillero datos) {

        DocumentoSemilleroEntity respu= documentoSemilleroRepository.save(documentoSemilleroMapper.obtenerEntity(datos));
        return true;
    }
}

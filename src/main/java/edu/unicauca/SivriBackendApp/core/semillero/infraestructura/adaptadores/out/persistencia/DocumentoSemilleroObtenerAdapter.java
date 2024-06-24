package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.DocumentoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IDocumentoSemilleroRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DocumentoSemilleroObtenerAdapter implements DocumentoSemilleroObtenerREPO {

    private final IDocumentoSemilleroRepository documentoSemilleroRepository;
    private final DocumentoSemilleroMapper documentoSemilleroMapper;

    public DocumentoSemilleroObtenerAdapter(IDocumentoSemilleroRepository documentoSemilleroRepository, DocumentoSemilleroMapper documentoSemilleroMapper) {
        this.documentoSemilleroRepository = documentoSemilleroRepository;
        this.documentoSemilleroMapper = documentoSemilleroMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return documentoSemilleroRepository.existsById(id);
    }

    @Override
    public Optional<DocumentoSemillero> obtenerPorId(int id) {
        Optional<DocumentoSemilleroEntity> respuestaJpa= documentoSemilleroRepository.findById(id);
        return respuestaJpa.map(documentoSemilleroMapper::obtenerModelo);
    }

    @Override
    public Optional<VerDoumentoSemillero> obtenerDatosDocumento() {
        //Optional<VerDoumentoSemillero> respuestaJpa=documentoSemilleroRepository
        return Optional.empty();
    }
}

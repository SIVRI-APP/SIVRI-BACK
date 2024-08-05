package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.VerDoumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.DocumentoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IDocumentoSemilleroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class DocumentoSemilleroObtenerAdapter implements DocumentoSemilleroObtenerREPO {

    private final IDocumentoSemilleroRepository documentoSemilleroRepository;
    private final DocumentoSemilleroMapper documentoSemilleroMapper;

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

    @Override
    public Integer existeDocumentoxIdSemillero(Integer idSemillero,String tipo) {
        Integer idDocumento= documentoSemilleroRepository.existeDocumentoxIdSemillero(idSemillero,tipo);
        return idDocumento;
    }
}

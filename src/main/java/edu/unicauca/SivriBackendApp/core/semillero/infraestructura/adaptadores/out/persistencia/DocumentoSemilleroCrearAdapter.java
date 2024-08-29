package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.DocumentoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IDocumentoSemilleroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DocumentoSemilleroCrearAdapter implements DocumentoSemilleroCrearREPO {
    private final IDocumentoSemilleroRepository documentoSemilleroRepository;
    private final DocumentoSemilleroMapper documentoSemilleroMapper;
    @Override
    public Boolean subirDocumentoSemillero(DocumentoSemillero nuevoDocumento) {
        DocumentoSemilleroEntity documento = documentoSemilleroRepository.save(documentoSemilleroMapper.obtenerEntity(nuevoDocumento));
        return true;
    }

    @Override
    public Optional<DocumentoSemillero> obtenerIdDocumento(int semilleroId, TipoDocumentoSemillero tipo) {
        String tip= tipo.toString();
        Optional<DocumentoSemilleroEntity> respuestaJpa=documentoSemilleroRepository.obtenerIdDocumento(semilleroId,tip);
        if (respuestaJpa.isPresent()){
            return Optional.of(documentoSemilleroMapper.obtenerModelo(respuestaJpa.get()));
        }
        return Optional.empty();
    }
    @Override
    public DocumentoSemillero obtDocuemntoxId(Semillero semillero,LocalDate fechaRegistro, TipoDocumentoSemillero tipo){
        DocumentoSemilleroEntity respuestaJpa=documentoSemilleroRepository.findBySemilleroAndFechaRegistroAndTipo(semillero,fechaRegistro,tipo);
        DocumentoSemillero respuesta=documentoSemilleroMapper.obtenerModelo(respuestaJpa);
        return respuesta;
    }
    public Boolean eliminaDocuemnto(DocumentoSemillero documento){
        documentoSemilleroRepository.delete(documentoSemilleroMapper.obtenerEntity(documento));
        return true;
    }

}

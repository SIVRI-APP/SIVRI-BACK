package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.DocumentoSemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.DocumentoSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.DocumentoSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.IDocumentoSemilleroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

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
}

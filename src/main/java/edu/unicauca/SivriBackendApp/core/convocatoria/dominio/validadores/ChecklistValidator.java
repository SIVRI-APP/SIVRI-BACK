package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.DocumentoConvocatoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ChecklistValidator {

    private final DocumentoConvocatoriaRepository documentoConvocatoriaRepository;

    public void validarCreacionDeConvocatoria(List<Checklist> checklists){

        //Documentos Nos existen
        for (Checklist item: checklists){
            if (!documentoConvocatoriaRepository.existsById(item.getDocumentoConvocatoria().getId())){
                throw new ReglaDeNegocioException("bad.documentoConvocatoriaNoExiste", List.of(String.valueOf(item.getDocumentoConvocatoria().getId())));
            }
        }
    }

}

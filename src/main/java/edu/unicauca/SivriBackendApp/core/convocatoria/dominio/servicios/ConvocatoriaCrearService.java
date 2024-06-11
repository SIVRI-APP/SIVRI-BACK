package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ChecklistCrearREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ConvocatoriaCrearREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.validadores.ChecklistValidator;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.validadores.ConvocatoriaValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConvocatoriaCrearService implements ConvocatoriaCrearCU {

    /**
     * Validadores
     */
    private final ConvocatoriaValidator convocatoriaValidator;
    private final ChecklistValidator checklistValidator;

    /**
     * Adaptadores
     */
    private final ConvocatoriaCrearREPO convocatoriaCrearREPO;
    private final ChecklistCrearREPO checklistCrearREPO;

    @Override
    public Respuesta<Boolean> crearConvocatoria(Convocatoria convocatoria, List<Checklist> checklists) {

        // Validaciones
        convocatoriaValidator.validarCreacionDeConvocatoria(convocatoria);
        checklistValidator.validarCreacionDeConvocatoria(checklists);

        // Persistir Convocatoria
        convocatoria.setEstado(ConvocatoriaEstado.PROGRAMADA);
        Convocatoria nuevaConvocatoria = convocatoriaCrearREPO.crearConvocatoria(convocatoria);

        // Persistir Checklists
        for (Checklist checklist : checklists) {
            checklist.setCompletado(false);
            checklist.setConvocatoria(nuevaConvocatoria);
            checklistCrearREPO.crearChecklist(checklist);
        }

        return new RespuestaHandler<>(200, "ok.convocatoria.creada", List.of(convocatoria.getNombre()), "", true).getRespuesta();
    }
}

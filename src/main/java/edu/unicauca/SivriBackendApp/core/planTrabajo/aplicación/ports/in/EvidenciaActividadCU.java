package edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
import jakarta.annotation.Resource;

import java.io.FileNotFoundException;

public interface EvidenciaActividadCU {
   // Integer existexActividadId(int idActividad);
    Respuesta<EvidenciaActividad> obtenerPorId(int id);
    Respuesta<Boolean> subirEvidenciaActividad(Integer actividadId, byte[] file,String name) throws Exception;
    Resource obtenerArchivoPorActividadId(Integer actividadId) throws Exception ;
}

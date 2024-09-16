package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.PrepararAgregarCompromisoDTO;


public interface CompromisosCU {

    Respuesta<PrepararAgregarCompromisoDTO> prepararAgregarCompromiso(long proyectoId);
    Respuesta<Boolean> agregarCompromiso(long proyectoId, long integranteId, int productoEnumId);


}

package edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.PrepararAgregarCompromisoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaCompromisoEntity;

public interface CompromisoREPO {

    PrepararAgregarCompromisoDTO prepararAgregarCompromiso(long proyectoId);

    Boolean agregarCompromiso(Proyecto proyecto, long integranteId, int productoEnumId);

    EvidenciaCompromisoEntity agregarEvidenciaCompromiso(EvidenciaCompromisoEntity evidenciaCompromiso);
}

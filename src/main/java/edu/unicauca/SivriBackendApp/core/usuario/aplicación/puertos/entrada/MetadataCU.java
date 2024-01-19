package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;

import java.util.List;

/**
 * La interfaz MetadataCU define los puertos de entrada para obtener metadata relacionada con usuarios,
 * como tipos de documento, géneros y tipos de usuario.
 */
public interface MetadataCU {

    /**
     * Obtiene una lista de tipos de documento disponibles.
     *
     * @return Respuesta que contiene la lista de tipos de documento.
     */
    Respuesta<List<TipoDocumento>> obtenerTiposDocumento();

    /**
     * Obtiene una lista de géneros (sexos) disponibles.
     *
     * @return Respuesta que contiene la lista de géneros.
     */
    Respuesta<List<Sexo>> obtenerSexo();

    /**
     * Obtiene una lista de tipos de usuario disponibles.
     *
     * @return Respuesta que contiene la lista de tipos de usuario.
     */
    Respuesta<List<TipoUsuario>> obtenerTiposUsuario();
}

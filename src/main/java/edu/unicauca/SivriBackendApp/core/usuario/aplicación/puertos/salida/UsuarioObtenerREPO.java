package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;


/**
 * La interfaz UsuarioObtenerREPO define el puerto de salida para obtener información
 * relacionada con usuarios desde el repositorio de persistencia.
 */
public interface UsuarioObtenerREPO {

    /**
     * Verifica la existencia de un usuario por su correo electrónico, tipo de documento y número de documento.
     *
     * @param correo          Correo electrónico del usuario.
     * @param tipoDocumento   Tipo de documento del usuario.
     * @param numeroDocumento Número de documento del usuario.
     * @return True si existe un usuario con los parámetros dados, de lo contrario, False.
     */
    boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento);

}

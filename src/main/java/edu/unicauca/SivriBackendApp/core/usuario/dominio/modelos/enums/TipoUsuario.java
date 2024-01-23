package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums;

/**
 * Enumeración que representa los posibles tipos de usuarios en el sistema.
 * - ADMINISTRATIVO: Usuario con rol administrativo.
 * - DOCENTE: Usuario con rol de docente.
 * - PREGRADO: Usuario con rol de estudiante de pregrado.
 * - POSGRADO: Usuario con rol de estudiante de posgrado.
 * - EGRESADO: Usuario con rol de egresado.
 * - EXTERNO: Usuario externo al sistema educativo.
 */
public enum TipoUsuario {
    ADMINISTRATIVO,
    DOCENTE,
    PREGRADO,
    POSGRADO,
    EGRESADO,
    EXTERNO
}

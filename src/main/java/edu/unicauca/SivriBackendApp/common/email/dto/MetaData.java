package edu.unicauca.SivriBackendApp.common.email.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO usado para mapear la llave y valor que deben usarse para construir un correo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaData {

	/**
	 * Representa la llave incrustada en la plantilla del correo
	 */
	private String key;

	/**
	 * Representa el valor que será inyectado en lugar donde se localize la llave en la plantilla del correo.
	 */
	private String value;

}

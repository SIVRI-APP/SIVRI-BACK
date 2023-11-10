package edu.unicauca.SivriBackendApp.common.email.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetaData {

	private String key;
	
	private String value;

}

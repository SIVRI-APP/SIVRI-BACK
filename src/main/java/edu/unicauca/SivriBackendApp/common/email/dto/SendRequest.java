package edu.unicauca.SivriBackendApp.common.email.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendRequest {

	private String to;
	
	private String subject;
	
	private Integer template;
	
	private List<MetaData> metaData;

}

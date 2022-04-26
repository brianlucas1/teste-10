package br.com.t10.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class StructorDTO {

	private String departamentName;
	
	private String headedBy;
	
	@NotEmpty(message = "{structor.firstName.obrigatorio}")
	private String firstName;
	
	@NotEmpty(message = "{structor.lastname.obrigatorio}")
	private String lastName;
	
	private String phone;
	
}

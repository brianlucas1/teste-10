package br.com.t10.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CourseDTO {

	@NotEmpty(message = "{course.departament.obrigatorio}")
	private String departamentName;
	
	private Integer instructorId;
	
	private Integer duration;
	
	@NotEmpty(message = "{course.name.obrigatorio}")
	private String name;
	
	
}

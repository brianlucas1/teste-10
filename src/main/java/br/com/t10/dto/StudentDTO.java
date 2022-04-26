package br.com.t10.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class StudentDTO {
	
	private Integer id;
	
	@NotEmpty(message = "{student.nome.obrigatorio}")
	private String firstName;
	
	@NotEmpty(message = "{student.sobrenome.obrigatorio}")
	private String lastName;
	
	private String phone;
	
	private Integer idCourse;

}

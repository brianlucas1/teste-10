package br.com.t10.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name="Departament")
public class DepartamentModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="departamentId")
	private String departamentName;
	
	private String location;
	
	@OneToMany(mappedBy = "departament")
	private List<CourseModel> courses;
	
	@OneToMany(mappedBy = "departament")
	private List<InstructorModel> instructor;
	
	
	
	
}

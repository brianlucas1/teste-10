package br.com.t10.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="Instructor")
public class InstructorModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="instructor_id")
	private Integer id;
		
	private String headedBy;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;

	@JsonIgnore
	@OneToMany(mappedBy = "instructor")
	private List<CourseModel> courses;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="departamentId", updatable = true)
	private DepartamentModel departament;
	
	
	
}

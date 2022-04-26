package br.com.t10.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Course")
public class CourseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	private Integer duration;
	
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private List<StudentModel> studants;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="instructor_id")
	private InstructorModel instructor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="departamentId")
	private DepartamentModel departament;
	

	public CourseModel() {
		
	}


	
	
}

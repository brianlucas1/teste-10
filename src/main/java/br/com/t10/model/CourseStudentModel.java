package br.com.t10.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "Course_Student")
public class CourseStudentModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="course_id")
	private Integer courseID;
	
	@Id
	@Column(name ="student_id")	
	private Integer stundetId;

	@ManyToOne	
	private StudentModel student;
	
	@ManyToOne
	private CourseModel course;
	
	
	
	
}

package br.com.t10.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.t10.model.CourseModel;
import br.com.t10.model.StudentModel;

public class StudentBuilder {
	
	private StudentModel student;
	
	private StudentBuilder() {
		
	}
	
	
	public static StudentBuilder oneStudentWithCourse() {
		
		StudentBuilder builder = new StudentBuilder();
		
		StudentModel stu = new StudentModel();
		CourseModel course = new CourseModel();
		List<CourseModel> courses = new ArrayList<CourseModel>();
		
		stu.setFirstName("JOSE");
		stu.setLastName("ALDO");
		stu.setPhone("123456");
		
		
		course.setDuration(10);
		course.setName("CURSO 1 ");
		
		courses.add(course);
		
		builder.student = new StudentModel();
		builder.student.setFirstName(stu.getFirstName());
		builder.student.setLastName(stu.getLastName());
		builder.student.setId(1);
		builder.student.setPhone(stu.getPhone());
		builder.student.setCourses(courses);
		
		return builder;
		
	}
	
	public static StudentBuilder oneStudent() {
		
		StudentBuilder builder = new StudentBuilder();
		
		StudentModel stu = new StudentModel();
		
		stu.setFirstName("JOSE");
		stu.setLastName("ALDO");
		stu.setPhone("123456");
		
		builder.student = new StudentModel();
		builder.student.setFirstName(stu.getFirstName());
		builder.student.setLastName(stu.getLastName());
		builder.student.setPhone(stu.getPhone());
		
		return builder;
		
	}
	
	public static StudentBuilder oneStudentNoName() {
		
		StudentBuilder builder = new StudentBuilder();
		
		StudentModel stu = new StudentModel();
		
		stu.setFirstName(null);
		stu.setLastName("ALDO");
		stu.setPhone("123456");
		builder.student = new StudentModel();
		builder.student.setFirstName(stu.getFirstName());
		builder.student.setLastName(stu.getLastName());
		builder.student.setPhone(stu.getPhone());
		return builder;
		
	}
	
	public static StudentBuilder oneStudentNoLastname() {
		
		StudentBuilder builder = new StudentBuilder();
		
		StudentModel stu = new StudentModel();
		
		stu.setFirstName("ARTUR");
		stu.setLastName(null);
		stu.setPhone("123456");
		builder.student = new StudentModel();
		builder.student.setFirstName(stu.getFirstName());
		builder.student.setLastName(stu.getLastName());
		builder.student.setPhone(stu.getPhone());
		return builder;
		
	}
	
	public static StudentBuilder oneStudentNoNameLast() {
		
		StudentBuilder builder = new StudentBuilder();
		
		StudentModel stu = new StudentModel();
		
		stu.setFirstName(null);
		stu.setLastName(null);
		stu.setPhone("123456");
		builder.student = new StudentModel();
		builder.student.setFirstName(stu.getFirstName());
		builder.student.setLastName(stu.getLastName());
		builder.student.setPhone(stu.getPhone());
		return builder;
		
	}
	
	public StudentModel agora(){
		return student;
	}


	public static StudentBuilder oneStudentWithCourseForUpdate() {
StudentBuilder builder = new StudentBuilder();
		
		StudentModel stu = new StudentModel();
		CourseModel course = new CourseModel();
		List<CourseModel> courses = new ArrayList<CourseModel>();
		
		stu.setFirstName("ANDERSON");
		stu.setLastName("SILVAAA");
		stu.setPhone("123456");
		
		
		course.setDuration(10);
		course.setName("CURSO 1 ");
		
		courses.add(course);
		
		builder.student = new StudentModel();
		builder.student.setFirstName(stu.getFirstName());
		builder.student.setLastName(stu.getLastName());
		builder.student.setId(1);
		builder.student.setPhone(stu.getPhone());
		builder.student.setCourses(courses);
		
		return builder;
	}

	
	
}

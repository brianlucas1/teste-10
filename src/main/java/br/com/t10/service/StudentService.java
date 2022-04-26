package br.com.t10.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.t10.excpetion.ResourceNotFoundException;
import br.com.t10.excpetion.StudentAlreadyInBaseExecption;
import br.com.t10.model.CourseModel;
import br.com.t10.model.StudentModel;
import br.com.t10.repository.CourseRepository;
import br.com.t10.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepo;
		
	@Autowired
	private CourseService courseService;
	
	public StudentModel findStudent(String user, String lasName, String phone)  {
	
		StudentModel studant = studentRepo.findByFirstNameAndLastNameAndPhone(user,lasName,phone);
		
		return studant;
		
	}

	public StudentModel insert(StudentModel studantModel, Integer idCourse) throws StudentAlreadyInBaseExecption {		
		
		StudentModel existStudant = findStudent(studantModel.getFirstName(), studantModel.getLastName(), studantModel.getPhone());
		
		if(existStudant == null) {			
			
			CourseModel course = courseService.findCourseById(idCourse);
				
			if(course != null) {			
				List<CourseModel> courses = new ArrayList<CourseModel>();			
				courses.add(course);
				studantModel.setCourses(courses);
				studentRepo.save(studantModel);						
				return studantModel;
			}			
		}else {
			throw new ResourceNotFoundException("Student already in dataBase");
		}
		
		return null;
		}
		
	
		

	public StudentModel findById(Integer id) {
		return studentRepo
		   .findById(id)
		   .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}

	public List<StudentModel> findall() {

		return studentRepo.findAll();
	}

	public void delete(Integer id) {

		studentRepo
		   .findById(id)
		   .map(student ->{
			   studentRepo.delete(student);
			   	return Void.TYPE;
		   })
		   .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Studant not found") );
			
	}

	public StudentModel update(Integer id, StudentModel studentUpdate) {
		
		return studentRepo
		.findById(id)		  
		   .map(student ->{
			   studentUpdate.setId(student.getId());
			   studentUpdate.setCourses(student.getCourses());
			   return studentRepo.save(studentUpdate);
			   	
		   })
		   .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
	
	
	
}

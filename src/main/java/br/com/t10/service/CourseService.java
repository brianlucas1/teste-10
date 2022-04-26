package br.com.t10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.t10.dto.CourseDTO;
import br.com.t10.excpetion.ResourceNotFoundException;
import br.com.t10.excpetion.StudentAlreadyInBaseExecption;
import br.com.t10.model.CourseModel;
import br.com.t10.model.DepartamentModel;
import br.com.t10.model.InstructorModel;
import br.com.t10.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private DepartamentService depService;
	
	@Autowired
	private InstructorService insServicce;

	public CourseModel insertNewCourse(CourseModel course, CourseDTO courseDTO) {
		
		DepartamentModel dep = depService.insert(courseDTO.getDepartamentName());
		
		InstructorModel ins = insServicce.insertById(courseDTO.getInstructorId());
		
		course.setDepartament(dep);		
		course.setInstructor(ins);
		
		
		return repo.save(course);
	}

	public CourseModel findCourseById(Integer id) {

		CourseModel course =  repo
				.findById(id)
				.orElseThrow( () ->  new ResourceNotFoundException("No find any Course with this Id"));
		 return	course;
	}

	public void saveCourse(CourseModel course) {

		repo.save(course);
		
	}

	public CourseModel findCourseByDepartament(String departamentName) {
			
		return repo
				.findByDepartament(departamentName);

	}


	public List<CourseModel> findByInstructor(String name) {		
		
		InstructorModel instru = insServicce.findByName(name);
		
		if(instru != null) {
			
			return repo
					.findByInstructor(instru);
		}
		
		return null;
	}

	public List<CourseModel> findall() {
		
		return repo.findAll();
	}

}

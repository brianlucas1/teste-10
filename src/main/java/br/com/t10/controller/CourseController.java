package br.com.t10.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.t10.dto.CourseDTO;
import br.com.t10.model.CourseModel;
import br.com.t10.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@PostMapping("/course/insert")
	public ResponseEntity<CourseModel> insertCourse(@RequestBody  CourseDTO courseDTO){
		
		CourseModel course = new CourseModel();
		BeanUtils.copyProperties(courseDTO,course);
		
		course = service.insertNewCourse(course,courseDTO);

		return new ResponseEntity<>(course, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/course/find/{id}")
	public ResponseEntity<CourseModel> findCourseById(@PathVariable Integer Id){
		
		CourseModel course = service.findCourseById(Id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/course/find")
	@ResponseStatus(HttpStatus.OK)
	public List<CourseModel> findAll(){
		
		List<CourseModel> course = service.findall();
		return course;
	}

	@GetMapping("/course/findbyinstructor/{name}")
	@ResponseStatus(HttpStatus.OK)
	public List<CourseModel> findByInstructor(@PathVariable String name){
		
		List<CourseModel> course = service.findByInstructor(name);
		
		return course;
	}
	
}

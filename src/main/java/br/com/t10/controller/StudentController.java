package br.com.t10.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.t10.dto.StudentDTO;
import br.com.t10.excpetion.StudentAlreadyInBaseExecption;
import br.com.t10.model.StudentModel;
import br.com.t10.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService service;

	@PostMapping("/studant/insert")
	public ResponseEntity<StudentModel> insertStudent(@RequestBody @Valid StudentDTO studentDTO) throws StudentAlreadyInBaseExecption  {
		
		StudentModel studantModel = new StudentModel();
		BeanUtils.copyProperties(studentDTO,studantModel);
		
		studantModel = service.insert(studantModel,studentDTO.getIdCourse());
		
		if(studantModel != null) {

			return new ResponseEntity<>(studantModel, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(studantModel,HttpStatus.BAD_REQUEST);
		}
		
	}
	
		@GetMapping("/studant/{id}")
		public  ResponseEntity<StudentModel> findById(@PathVariable Integer id){			
			
			StudentModel studantModel = service.findById(id);
			
			return new ResponseEntity<>(studantModel, HttpStatus.OK);
				   
		}
		
		@GetMapping("/studant/all")
		public  List<StudentModel> findAll(){
						
			List<StudentModel> studantModel = service.findall();

			return studantModel;
				   
		}
		
		@DeleteMapping("/studant/delet/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public  ResponseEntity<StudentModel> delet(@PathVariable Integer id){
			
			service.delete(id);
			
			return new ResponseEntity<>( HttpStatus.OK);
			
		}
		
		@PutMapping("/studant/update/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public ResponseEntity<StudentModel> update(@PathVariable Integer id, @RequestBody StudentModel studentUpdate){
			
			 StudentModel studantModel = service.update(id,studentUpdate);			
			
			return new ResponseEntity<>(studantModel, HttpStatus.OK);
			
		}
	
}

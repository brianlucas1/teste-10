package br.com.t10.controller;

import java.util.ArrayList;
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

import br.com.t10.dto.StructorDTO;
import br.com.t10.model.InstructorModel;
import br.com.t10.service.InstructorService;

@RestController
@RequestMapping("/api")
public class InstructorController {
	
	@Autowired
	private InstructorService service;

	@PostMapping("/instructor/insert")
	public ResponseEntity<InstructorModel> insertStructor(@RequestBody @Valid StructorDTO structorDTO) {
		
		InstructorModel instructorModel = new InstructorModel();
		BeanUtils.copyProperties(structorDTO,instructorModel);
		
		instructorModel = service.insert(instructorModel,structorDTO);
		
		return new ResponseEntity<>(instructorModel, HttpStatus.CREATED);
	}
	
		@GetMapping("/instructor/{id}")
		public  ResponseEntity<InstructorModel> findById(@PathVariable Integer id){
						
			InstructorModel instructorModel = service.findById(id);
				   
			return new ResponseEntity<>(instructorModel, HttpStatus.OK);
		}
		
		@GetMapping("/instructor/all")
		public  List<InstructorModel> findAll(){						
			
			return service.findAll();
				   
		}
		
		@DeleteMapping("/instructor/delete/{id}")
		@ResponseStatus(HttpStatus.OK)
		public void  delete(@PathVariable Integer id){
			
			service.delete(id);
	
		}
		
		@PutMapping("/instructor/update/{id}")
		public ResponseEntity<InstructorModel> update(@PathVariable Integer id, @RequestBody InstructorModel StructorUpdate){
			
	
			 InstructorModel instructorModel = service.update(StructorUpdate,id);
			
			return new ResponseEntity<>(instructorModel, HttpStatus.OK);
		}
		
		
	
}

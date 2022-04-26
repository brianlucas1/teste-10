package br.com.t10.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.t10.dto.StructorDTO;
import br.com.t10.model.CourseModel;
import br.com.t10.model.DepartamentModel;
import br.com.t10.model.InstructorModel;
import br.com.t10.repository.InstructorRepository;

@Service
public class InstructorService {
	
	
	@Autowired
	private InstructorRepository repository;
	
	@Autowired
	private DepartamentService departamentService;
	
	

	public InstructorModel insert(InstructorModel instructorModel,  StructorDTO structorDTO) {
		
		DepartamentModel departament = departamentService.findCourseByDepartament(structorDTO.getDepartamentName());
				
		if(departament != null) {
			instructorModel.setDepartament(departament);
		}
		
		return repository
			.save(instructorModel);
	}

	public InstructorModel findById(Integer id) {
		 return repository
		   .findById(id)
		   .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"instructor not found") );
	}

	public List<InstructorModel> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {
		repository
		   .findById(id)
		   .map(Structor ->{
			   	repository.delete(Structor);
			   	return Void.TYPE;
		   })
		   .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "instructor not found") );
	}

	public InstructorModel update(InstructorModel structorUpdate, Integer id) {
		
		return repository
		.findById(id)
		   .map(Structor ->{
			   structorUpdate.setId(Structor.getId());
			   structorUpdate.setDepartament(Structor.getDepartament());
			   return repository.save(structorUpdate);
			   	
		   })
		   .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"instructor not found") );
	}

	public InstructorModel insertById(Integer instructorId) {
		
		InstructorModel instructorInsert = new InstructorModel();
		
		instructorInsert.setId(instructorId);
		
		return repository
				.findById(instructorId)
				.orElse(repository.save(instructorInsert));
	}

	public InstructorModel findByName(String name) {
		
		return repository.findByFirstName(name);
	}

	
	
	
}

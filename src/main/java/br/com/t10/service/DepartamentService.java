package br.com.t10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.t10.model.DepartamentModel;
import br.com.t10.repository.DepartamentRepository;

@Service
public class DepartamentService {

	@Autowired
	DepartamentRepository repo;

	public DepartamentModel findCourseByDepartament(String departamentName) {
		
		return repo.findByDepartamentName(departamentName);
	}

	public DepartamentModel insert(String departamentName) {
		
		DepartamentModel dep = new DepartamentModel();
		
		dep.setDepartamentName(departamentName);
		
		return repo.save(dep);
	}
	
	
}

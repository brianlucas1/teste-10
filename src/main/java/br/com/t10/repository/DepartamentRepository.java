package br.com.t10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.t10.model.DepartamentModel;

public interface DepartamentRepository  extends JpaRepository<DepartamentModel, String>{

	DepartamentModel findByDepartamentName(String departamentName);

}

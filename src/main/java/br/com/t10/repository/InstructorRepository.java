package br.com.t10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.t10.model.InstructorModel;

public interface InstructorRepository extends JpaRepository<InstructorModel, Integer> {

	InstructorModel findByFirstName(String name);

}

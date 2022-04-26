package br.com.t10.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.t10.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

	StudentModel findByFirstNameAndLastNameAndPhone(String user, String lasName, String phone);

}

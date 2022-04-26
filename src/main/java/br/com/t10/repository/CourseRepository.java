package br.com.t10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.t10.model.CourseModel;
import br.com.t10.model.InstructorModel;

public interface CourseRepository  extends JpaRepository<CourseModel,Integer>{

	CourseModel findByDepartament(String departamentName);

	List<CourseModel> findByInstructor(InstructorModel instru);

}

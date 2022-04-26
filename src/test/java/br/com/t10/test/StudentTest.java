package br.com.t10.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.t10.builder.StudentBuilder;
import br.com.t10.model.StudentModel;
import br.com.t10.repository.StudentRepository;
import br.com.t10.service.StudentService;

@ExtendWith(SpringExtension.class)
	public class StudentTest {

	@Mock 
    private StudentRepository repo;
	

    @InjectMocks 
    private StudentService service;
    

    @BeforeEach
    void setup() {
    	BDDMockito.when(repo.save(any())).thenReturn(StudentBuilder.oneStudentWithCourse().agora());
    	BDDMockito.when(repo.findById(anyInt())).thenReturn(Optional.of(StudentBuilder.oneStudentWithCourse().agora()));
    }	
    
    

	    @Test
	    void should_save() {
	    	
	    	StudentModel stu = repo.save(StudentBuilder.oneStudentWithCourse().agora());
	    	
	    	Assertions.assertThat(stu).isNotNull();
	        Assertions.assertThat(stu.getId()).isNotNull();
	        Assertions.assertThat(stu.getId()).isEqualTo(1);
	    
	    }
	    
	    @Test
	    void should_findById() {
	    	
	    	Integer expectedId = StudentBuilder.oneStudentWithCourse().agora().getId();
	    	
	    	StudentModel stu = service.findById(1);
	    	
	    	Assertions.assertThat(stu).isNotNull();
	        Assertions.assertThat(stu.getId()).isNotNull();
	        Assertions.assertThat(stu.getId()).isEqualTo(expectedId);
	    
	    }
	    
	    @Test
	    void should_Delete() {
	        Assertions.assertThatCode(() -> service.delete(1))
	                .doesNotThrowAnyException();
	    }
	    
	    @Test
	    void should_update() {
	    	
	    	StudentModel stuUpdate =   StudentBuilder.oneStudentWithCourseForUpdate().agora();
	       
	    	StudentModel stu =   StudentBuilder.oneStudentWithCourse().agora();
	    	
	    	StudentModel stuRet = repo.save(stu);
	    	
	    	StudentModel update = service.update(stu.getId(), stuUpdate);
	    	
	    	Assertions.assertThat(update).isNotNull();
	        Assertions.assertThat(update.getId()).isNotNull();

	    	
	    }
	    
}

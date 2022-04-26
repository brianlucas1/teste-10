package br.com.t10.excpetion;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentAlreadyInBaseExecption extends RuntimeException {

	public StudentAlreadyInBaseExecption(String message) {
	        super(message);
	    }
	
}

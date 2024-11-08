package com.std.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.std.Exception.CountException;
import com.std.Exception.DeptException;
import com.std.Exception.MaxException;
import com.std.Exception.NameException;

@RestControllerAdvice
public class GobalException {
	@ExceptionHandler(NameException.class)
	public ResponseEntity<Object> noname(NameException l) 
	{
		return new ResponseEntity<>("No value Found",HttpStatus.NOT_FOUND);		
	}
	
	// Task 1
	
	@ExceptionHandler(MaxException.class)
	public ResponseEntity<Object> name1(MaxException l) 
	{
		return new ResponseEntity<>("Max value  Not Found",HttpStatus.NOT_FOUND);		
	}
	
	// Task 2
	
	@ExceptionHandler(DeptException.class)
	public ResponseEntity<Object> name2(DeptException l) 
	{
		return new ResponseEntity<>("Dept name Not Found",HttpStatus.NOT_FOUND);		
	}
    
	// Task 3
	
		@ExceptionHandler(CountException.class)
		public ResponseEntity<Object> name3(CountException l) 
		{
			return new ResponseEntity<>("Count Not Found",HttpStatus.NOT_FOUND);		
		}

}

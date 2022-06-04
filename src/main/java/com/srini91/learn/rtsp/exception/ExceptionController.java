package com.srini91.learn.rtsp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

 public class ExceptionController {
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<ExceptionMessage> handleUserAlreadyExistsException()  {
		 return ResponseEntity
			        .status(HttpStatus.BAD_REQUEST)
			        .body(ExceptionMessage.builder().errMessage("User Already exists").errCode(400).build()); 
	}
	
	
}

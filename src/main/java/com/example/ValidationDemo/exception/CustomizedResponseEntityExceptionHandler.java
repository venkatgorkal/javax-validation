package com.example.ValidationDemo.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	  @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	  handleAllExceptions(Exception ex, WebRequest request) { ExceptionResponse
	  exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	  request.getDescription(false),null); return new ResponseEntity(exceptionResponse,
	  HttpStatus.INTERNAL_SERVER_ERROR); }
	  
	  
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = ex.getBindingResult().getAllErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed", "400", errors);

		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	/*
	 * @ExceptionHandler public ResponseEntity<Object>
	 * handle(ConstraintViolationException exception) { //you will get all javax
	 * failed validation, can be more than one //so you can return the set of error
	 * messages or just the first message Set<ConstraintViolation<?>>
	 * constraintViolationExceptions =exception.getConstraintViolations();
	 * //ErrorField field = null; String message =""; for
	 * (Iterator<ConstraintViolation<?>> iterator =
	 * constraintViolationExceptions.iterator();iterator.hasNext(); ) {
	 * ConstraintViolation<?> next = iterator.next();
	 * System.out.println(((PathImpl)next.getPropertyPath())
	 * .getLeafNode().getName() + "  " +next.getMessage()); message =
	 * next.getMessage();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * String errorMessage = new
	 * ArrayList()<>(exception.getConstraintViolations()).get(0).getMessage();
	 * ApiError apiError = new ApiError(errorMessage, errorMessage, 1000);
	 * 
	 * 
	 * ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
	 * "Validation Failed", message); return new ResponseEntity(exceptionResponse,
	 * HttpStatus.BAD_REQUEST); }
	 */
}
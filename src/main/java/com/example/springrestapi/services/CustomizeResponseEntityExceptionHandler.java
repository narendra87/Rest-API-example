package com.example.springrestapi.services;

import com.example.springrestapi.modal.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, WebRequest request) {
       ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
      return new ResponseEntity<Object>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
   }
    @ExceptionHandler(NoRecordFoundException.class)
    protected ResponseEntity<Object> handleNoRecordFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
//execute when request is not correct / bad
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),"Validation error");
        return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}

package it.computer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.computer.exception.ValidazioneException;

@ControllerAdvice(basePackages = "it.computer.controller")
public class ExceptionAdvisor {
	
	@ExceptionHandler(ValidazioneException.class)
    public ResponseEntity<List<String>> handleException(ValidazioneException e){
		List<String> errori = new ArrayList<>();
		for (FieldError errore : e.getBindingResult().getFieldErrors()) {
			errori.add(errore.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errori);
    }

}

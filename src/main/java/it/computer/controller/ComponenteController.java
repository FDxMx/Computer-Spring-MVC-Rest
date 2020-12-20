package it.computer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.computer.dto.ComponenteDTO;
import it.computer.dto.ErroreDTO;
import it.computer.exception.ValidazioneException;
import it.computer.service.ComponenteService;
import it.computer.validator.ComponenteInsertValidator;

@RestController
@RequestMapping("componente")
public class ComponenteController {
	
	@Autowired
	private ComponenteInsertValidator componenteInsertValidator;
	
	@Autowired
	private ComponenteService componenteService;
	
	@PostMapping("insert")
	public ResponseEntity<String> insert (@RequestBody ComponenteDTO componenteDTO){
		try {
			componenteInsertValidator.validate(componenteDTO);
		} catch (ValidazioneException e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore di validazione");
		}
		componenteService.insert(componenteDTO);
        return ResponseEntity.ok("Inserimento effettuato");
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreDTO> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroreDTO("ERRORE!!!"));
    }

}

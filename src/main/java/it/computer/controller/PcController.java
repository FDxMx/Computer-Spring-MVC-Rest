package it.computer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.computer.dto.ErroreDTO;
import it.computer.dto.PcDTO;
import it.computer.exception.ValidazioneException;
import it.computer.service.PcService;
import it.computer.validator.PcInsertValidator;

@RestController
@RequestMapping("pc")
public class PcController {
	
	@Autowired
	private PcInsertValidator pcInsertValidator;
	
	@Autowired
	private PcService pcService;
	
	@PostMapping("insert")
	public ResponseEntity<String> insert (@RequestBody PcDTO pcDTO) {
			try {
				pcInsertValidator.validate(pcDTO);
			} catch (ValidazioneException e) {
				e.printStackTrace();
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore di validazione");
			}
			pcService.insert(pcDTO);
	        return ResponseEntity.ok("Inserimento effettuato");
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErroreDTO> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroreDTO("ERRORE!!!"));
    }

}

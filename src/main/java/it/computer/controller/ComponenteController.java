package it.computer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.computer.dto.ComponenteDTO;
import it.computer.dto.messages.ComponenteInsertDTO;
import it.computer.dto.messages.ComponenteUpdateDTO;
import it.computer.exception.ValidazioneException;
import it.computer.service.ComponenteService;

@RestController
@RequestMapping("componente")
public class ComponenteController {
	
	@Autowired
	private ComponenteService componenteService;
	
	@GetMapping("list")
	public ResponseEntity<List<ComponenteDTO>> list(){
		return ResponseEntity.ok(componenteService.list());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<ComponenteDTO> get(@PathVariable("id") Integer id){
		return ResponseEntity.ok(componenteService.findById(id));
	}
	
	@PostMapping("insert")
	public ResponseEntity<String> insert (@Valid @RequestBody ComponenteInsertDTO componenteInsertDTO, BindingResult bindingResult) throws ValidazioneException{
		if (bindingResult.hasErrors()) {
            throw new ValidazioneException(bindingResult);
        } else {
        	componenteService.insert(componenteInsertDTO);
        	return ResponseEntity.ok("Inserimento effettuato");
        }
	}
	
	@PutMapping("update")
	public ResponseEntity<String> update (@Valid @RequestBody ComponenteUpdateDTO componenteUpdateDTO, BindingResult bindingResult) throws ValidazioneException {
		if (bindingResult.hasErrors()) {
            throw new ValidazioneException(bindingResult);
        } else {
        	componenteService.update(componenteUpdateDTO);
        	return ResponseEntity.ok("Aggiornamento effettuato");
        } 
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete (@PathVariable("id") Integer id){
		componenteService.delete(id);
		return ResponseEntity.ok("Eliminazione effettuata");
	}
	
}

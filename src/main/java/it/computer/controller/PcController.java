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

import it.computer.dto.PcDTO;
import it.computer.dto.messages.PcInsertDTO;
import it.computer.dto.messages.PcUpdateDTO;
import it.computer.exception.ValidazioneException;
import it.computer.exception.ValidazioneIdException;
import it.computer.service.PcService;

@RestController
@RequestMapping("pc")
public class PcController {
	
	@Autowired
	private PcService pcService;
	
	@GetMapping("list")
	public ResponseEntity<List<PcDTO>> list(){
		return ResponseEntity.ok(pcService.list());
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<PcDTO> get(@PathVariable("id") String id) throws ValidazioneIdException{
		try {
			return ResponseEntity.ok(pcService.findById(Integer.parseInt(id)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidazioneIdException();
		}
	}
	
	@PostMapping("insert")
	public ResponseEntity<String> insert (@Valid @RequestBody PcInsertDTO pcInsertDTO, BindingResult bindingResult) throws ValidazioneException {
		if (bindingResult.hasErrors()) {
            throw new ValidazioneException(bindingResult);
        } else {
        	pcService.insert(pcInsertDTO);
        	return ResponseEntity.ok("Inserimento effettuato");
        }
	}
	
	@PutMapping("update")
	public ResponseEntity<String> update (@Valid @RequestBody PcUpdateDTO pcUpdateDTO, BindingResult bindingResult) throws ValidazioneException {
		if (bindingResult.hasErrors()) {
            throw new ValidazioneException(bindingResult);
        } else {
        	pcService.update(pcUpdateDTO);
        	return ResponseEntity.ok("Aggiornamento effettuato");
        } 
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete (@PathVariable("id") String id) throws ValidazioneIdException{
		try {
			pcService.delete(Integer.parseInt(id));
			return ResponseEntity.ok("Eliminazione effettuata");
		} catch (Exception e) {
			throw new ValidazioneIdException();
		}
	}
	
}

package it.computer.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import it.computer.dto.ComponenteDTO;
import it.computer.exception.ValidazioneException;

@Component
public class ComponenteInsertValidator {
	
public void validate(ComponenteDTO componenteDTO) throws ValidazioneException{
		
//		if(componenteDTO.getMarca() == null || componenteDTO.getMarca().equals("") || StringUtils.isNumeric(componenteDTO.getMarca())) {
//			throw new ValidazioneException("Errore validazione marca");
//		}
//		if(componenteDTO.getDescrizione() == null || componenteDTO.getDescrizione().equals("")) {
//			throw new ValidazioneException("Errore validazione descrizione");
//		}
//		if(componenteDTO.getCodice() == null || componenteDTO.getCodice().equals("")) {
//			throw new ValidazioneException("Errore validazione codice");
//		}
	}

}

package it.computer.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import it.computer.dto.PcDTO;
import it.computer.exception.ValidazioneException;

@Component
public class PcInsertValidator{

	public void validate(PcDTO pcDTO) throws ValidazioneException{
		
		if(pcDTO.getMarca() == null || pcDTO.getMarca().equals("") || StringUtils.isNumeric(pcDTO.getMarca())) {
			throw new ValidazioneException();
		}
		if(pcDTO.getDescrizione() == null || pcDTO.getDescrizione().equals("")) {
			throw new ValidazioneException();
		}
		if(pcDTO.getComponentiDTO() == null || pcDTO.getComponentiDTO().size() == 0) {
			throw new ValidazioneException();
		}
	}

}

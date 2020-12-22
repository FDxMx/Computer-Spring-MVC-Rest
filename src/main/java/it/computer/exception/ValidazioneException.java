package it.computer.exception;

import org.springframework.validation.BindingResult;

public class ValidazioneException extends Exception{
	
	private BindingResult bindingResult;

	private static final long serialVersionUID = -3567295312248521099L;
	
	public ValidazioneException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
}

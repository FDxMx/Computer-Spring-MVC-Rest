package it.computer.dto.messages;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.computer.dto.ComponenteDTO;

public class PcInsertDTO {
	
	@NotBlank(message = "MARCA obbligatoria")
	private String marca;
	@NotBlank(message = "DESCRIZIONE obbligatoria")
	private String descrizione;
	@NotNull(message = "COMPONENTI obbligatori")
	private List<ComponenteDTO> componentiDTO;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<ComponenteDTO> getComponentiDTO() {
		return componentiDTO;
	}
	public void setComponentiDTO(List<ComponenteDTO> componentiDTO) {
		this.componentiDTO = componentiDTO;
	}
	
}

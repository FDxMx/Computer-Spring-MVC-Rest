package it.computer.dto.messages;

import java.util.List;

import javax.validation.constraints.NotBlank;

import it.computer.dto.ComponenteDTO;

public class PcUpdateDTO {
	
	@NotBlank(message = "ID obbligatorio")
	private String id;
	@NotBlank(message = "MARCA obbligatoria")
	private String marca;
	@NotBlank(message = "DESCRIZIONE obbligatoria")
	private String descrizione;
	private List<ComponenteDTO> componentiDTO;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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

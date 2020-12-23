package it.computer.dto;

import java.util.List;

import javax.validation.constraints.Positive;

public class PcDTO {
	
	@Positive
	private String id;
	private String marca;
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

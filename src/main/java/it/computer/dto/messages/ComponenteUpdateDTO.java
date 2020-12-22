package it.computer.dto.messages;

import javax.validation.constraints.NotBlank;

import it.computer.dto.PcDTO;

public class ComponenteUpdateDTO {
	
	@NotBlank(message = "ID obbligatorio")
	private String id;
	@NotBlank(message = "MARCA obbligatoria")
	private String marca;
	@NotBlank(message = "DESCRIZIONE obbligatoria")
	private String descrizione;
	@NotBlank(message = "CODICE obbligatoria")
	private String codice;
	private PcDTO PcDTO;
	
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
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public PcDTO getPcDTO() {
		return PcDTO;
	}
	public void setPcDTO(PcDTO pcDTO) {
		PcDTO = pcDTO;
	}
	
	

}

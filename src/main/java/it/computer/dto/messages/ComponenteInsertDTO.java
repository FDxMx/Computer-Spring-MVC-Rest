package it.computer.dto.messages;

import javax.validation.constraints.NotBlank;

import it.computer.dto.PcDTO;

public class ComponenteInsertDTO {
	
	@NotBlank(message = "MARCA obbligatoria")
	private String marca;
	@NotBlank(message = "DESCRIZIONE obbligatoria")
	private String descrizione;
	@NotBlank(message = "CODICE obbligatorio")
	private String codice;
	private PcDTO pcDTO;
	
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
		return pcDTO;
	}
	public void setPcDTO(PcDTO pcDTO) {
		this.pcDTO = pcDTO;
	}
	
}

package it.computer.dto;

public class ComponenteDTO {
	
	private String id;
	private String marca;
	private String descrizione;
	private String codice;
	private PcDTO pcDTO;
	
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
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}

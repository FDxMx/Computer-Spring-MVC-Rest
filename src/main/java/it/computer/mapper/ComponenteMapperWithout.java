package it.computer.mapper;

import org.springframework.stereotype.Component;

import it.computer.dto.ComponenteDTO;
import it.computer.model.Componente;

@Component
public class ComponenteMapperWithout extends AbstractMapper<Componente, ComponenteDTO>{

	@Override
	public ComponenteDTO convertEntityToDto(Componente entity) {
		if (entity == null) {
			return null;
		}
		ComponenteDTO componenteDTO = new ComponenteDTO();
		componenteDTO.setId(String.valueOf(entity.getId()));
		componenteDTO.setCodice(entity.getCodice());
		componenteDTO.setMarca(entity.getMarca());
		componenteDTO.setDescrizione(entity.getDescrizione());
		return componenteDTO;
	}

	@Override
	public Componente convertDtoToEntity(ComponenteDTO dto) {
		if (dto == null) {
			return null;
		}
		Componente componente = new Componente();
		if(dto.getId() != null) {
			componente.setId(Integer.parseInt(dto.getId()));
		}
		componente.setMarca(dto.getMarca());
		componente.setCodice(dto.getCodice());
		componente.setDescrizione(dto.getDescrizione());
		return componente;
	}

}

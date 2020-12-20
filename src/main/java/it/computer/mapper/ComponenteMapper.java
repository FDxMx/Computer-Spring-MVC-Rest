package it.computer.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.computer.dto.ComponenteDTO;
import it.computer.model.Componente;

@Component
public class ComponenteMapper extends AbstractMapper<Componente, ComponenteDTO>{
	
	@Autowired
	private PcMapper pcMapper;

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
		componenteDTO.setPcDTO(pcMapper.convertEntityToDto(entity.getPc()));
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
		if(dto.getPcDTO() != null) {
			componente.setPc(pcMapper.convertDtoToEntity(dto.getPcDTO()));
		}
		return componente;
	}

}

package it.computer.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.computer.dto.PcDTO;
import it.computer.model.Pc;

@Component
public class PcMapper extends AbstractMapper<Pc, PcDTO>{
	
	@Autowired
	private ComponenteMapper componenteMapper;
	
	@Override
	public PcDTO convertEntityToDto(Pc entity) {
		if (entity == null) {
			return null;
		}
		PcDTO pcDTO = new PcDTO();
		pcDTO.setId(String.valueOf(entity.getId()));
		pcDTO.setMarca(entity.getMarca());
		pcDTO.setDescrizione(entity.getDescrizione());
		pcDTO.setComponentiDTO(componenteMapper.convertEntityToDto(entity.getComponenti()));
		return pcDTO;
	}

	@Override
	public Pc convertDtoToEntity(PcDTO dto) {
		if (dto == null) {
			return null;
		}
		Pc pc = new Pc();
		if(dto.getId() != null) {
			pc.setId(Integer.parseInt(dto.getId()));
		}
		pc.setMarca(dto.getMarca());
		pc.setDescrizione(dto.getDescrizione());
		pc.setComponenti(componenteMapper.convertDtoToEntity(dto.getComponentiDTO()));
		return pc;
	}

}

package it.computer.mapper;

import org.springframework.stereotype.Component;

import it.computer.dto.PcDTO;
import it.computer.model.Pc;

@Component
public class PcMapperWithout extends AbstractMapper<Pc, PcDTO>{

	@Override
	public PcDTO convertEntityToDto(Pc entity) {
		if (entity == null) {
			return null;
		}
		PcDTO pcDTO = new PcDTO();
		pcDTO.setId(String.valueOf(entity.getId()));
		pcDTO.setMarca(entity.getMarca());
		pcDTO.setDescrizione(entity.getDescrizione());
		return pcDTO;
	}

	@Override
	public Pc convertDtoToEntity(PcDTO dto) {
		if (dto == null) {
			return null;
		}
		Pc pc = new Pc();
		if(dto.getId() != null && !dto.getId().equals("")) {
			pc.setId(Integer.parseInt(dto.getId()));
		}
		pc.setMarca(dto.getMarca());
		pc.setDescrizione(dto.getDescrizione());
		return pc;
	}

}

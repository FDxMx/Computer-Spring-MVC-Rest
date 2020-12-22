package it.computer.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.computer.dto.PcDTO;
import it.computer.model.Pc;
import it.computer.service.ComponenteService;

@Component
public class PcMapper extends AbstractMapper<Pc, PcDTO>{
	
	@Autowired
	private ComponenteMapper componenteMapper;
	
	@Autowired
	private ComponenteService componenteService;
	
	@Override
	public PcDTO convertEntityToDto(Pc entity) {
		if (entity == null) {
			return null;
		}
		PcDTO pcDTO = new PcDTO();
		pcDTO.setId(String.valueOf(entity.getId()));
		pcDTO.setMarca(entity.getMarca());
		pcDTO.setDescrizione(entity.getDescrizione());
		if(entity.getComponenti().size() > 0) {
		pcDTO.setComponentiDTO(componenteMapper.convertEntityToDto(entity.getComponenti()));
		}
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
		if(dto.getComponentiDTO() != null) {
			pc.setComponenti(dto.getComponentiDTO().stream().map(c -> componenteMapper.convertDtoToEntity(componenteService.findById(Integer.parseInt(c.getId())))).collect(Collectors.toList()));
		}
		return pc;
	}

}

package it.computer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.computer.dto.ComponenteDTO;
import it.computer.dto.messages.ComponenteInsertDTO;
import it.computer.dto.messages.ComponenteUpdateDTO;
import it.computer.mapper.ComponenteMapper;
import it.computer.mapper.ComponenteMapperWithout;
import it.computer.repository.ComponenteRepository;

@Service
public class ComponenteService {
	
	@Autowired
	private ComponenteRepository componenteRepository;
	
	@Autowired
	private ComponenteMapper componenteMapper;
	
	@Autowired
	private ComponenteMapperWithout componenteMapperWithout;
	
	public void insert (ComponenteInsertDTO componenteInsertDTO) {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		componenteDTO.setCodice(componenteInsertDTO.getCodice());
		componenteDTO.setDescrizione(componenteInsertDTO.getDescrizione());
		componenteDTO.setMarca(componenteInsertDTO.getMarca());
		componenteDTO.setPcDTO(componenteInsertDTO.getPcDTO());
		componenteRepository.save(componenteMapper.convertDtoToEntity(componenteDTO));
	}
	
	public ComponenteDTO findById(Integer id) {
		return componenteMapperWithout.convertEntityToDto(componenteRepository.findById(id).get());
	}
	
	public void update(ComponenteUpdateDTO componenteUpadteDTO) {
		ComponenteDTO componenteDTO = new ComponenteDTO();
		componenteDTO.setId(componenteUpadteDTO.getId());
		componenteDTO.setCodice(componenteUpadteDTO.getCodice());
		componenteDTO.setDescrizione(componenteUpadteDTO.getDescrizione());
		componenteDTO.setMarca(componenteUpadteDTO.getMarca());
		componenteDTO.setPcDTO(componenteUpadteDTO.getPcDTO());
		componenteRepository.save(componenteMapper.convertDtoToEntity(componenteDTO));
	}
	
	public void delete (Integer id) {
		componenteRepository.deleteById(id);
	}
	
	public List<ComponenteDTO> list(){
		return componenteMapperWithout.convertEntityToDto(componenteRepository.findAll());
	}

}

package it.computer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.computer.dto.ComponenteDTO;
import it.computer.mapper.ComponenteMapper;
import it.computer.repository.ComponenteRepository;

@Service
public class ComponenteService {
	
	@Autowired
	private ComponenteRepository componenteRepository;
	
	@Autowired
	private ComponenteMapper componenteMapper;
	
	public void insert (ComponenteDTO componenteDTO) {
		componenteRepository.save(componenteMapper.convertDtoToEntity(componenteDTO));
	}

}

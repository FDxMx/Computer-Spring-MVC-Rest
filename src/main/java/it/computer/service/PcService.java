package it.computer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.computer.dto.PcDTO;
import it.computer.mapper.PcMapper;
import it.computer.repository.PcRepository;

@Service
public class PcService {
	
	@Autowired
	private PcRepository pcRepository;
	
	@Autowired
	private PcMapper pcMapper;
	
	public void insert(PcDTO pcDTO){
		pcRepository.save(pcMapper.convertDtoToEntity(pcDTO));
	}

}

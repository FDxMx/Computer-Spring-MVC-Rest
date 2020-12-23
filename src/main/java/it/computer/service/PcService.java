package it.computer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.computer.dto.PcDTO;
import it.computer.dto.messages.PcInsertDTO;
import it.computer.dto.messages.PcUpdateDTO;
import it.computer.mapper.PcMapper;
import it.computer.mapper.PcMapperWithout;
import it.computer.model.Componente;
import it.computer.model.Pc;
import it.computer.repository.ComponenteRepository;
import it.computer.repository.PcRepository;

@Service
public class PcService {
	
	@Autowired
	private PcRepository pcRepository;
	
	@Autowired
	private PcMapper pcMapper;
	
	@Autowired
	private PcMapperWithout pcMapperWithout;
	
	@Autowired
	private ComponenteRepository componenteRepository;
	
	public void insert(PcInsertDTO pcInsertDTO){
		PcDTO pcDTO = new PcDTO();
		pcDTO.setMarca(pcInsertDTO.getMarca());
		pcDTO.setDescrizione(pcInsertDTO.getDescrizione());
		pcDTO.setComponentiDTO(pcInsertDTO.getComponentiDTO());
		Pc pc = pcMapper.convertDtoToEntity(pcDTO);
		pcRepository.save(pc);
		for (Componente componente : pc.getComponenti()) {
			componente.setPc(pc);
			componenteRepository.save(componente);
		}
	}
	
	public void update(PcUpdateDTO pcUpdateDTO){
		PcDTO pcDTO = new PcDTO();
		pcDTO.setId(pcUpdateDTO.getId());
		pcDTO.setMarca(pcUpdateDTO.getMarca());
		pcDTO.setDescrizione(pcUpdateDTO.getDescrizione());
		pcRepository.save(pcMapper.convertDtoToEntity(pcDTO));
	}
	
	public void delete (Integer id) {
		pcRepository.deleteById(id);
	}
	
	public List<PcDTO> list(){
		return pcMapperWithout.convertEntityToDto(pcRepository.findAll());
	}
	
	public PcDTO findById(Integer id) {
		return pcMapperWithout.convertEntityToDto(pcRepository.findById(id).get());
	}

}

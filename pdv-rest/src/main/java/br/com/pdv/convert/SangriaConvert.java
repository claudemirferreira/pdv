package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.SangriaDTO;
import br.com.pdv.model.entity.Sangria;

@Component
public class SangriaConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public SangriaDTO convertToDTO(Sangria entity) {
		SangriaDTO dto = modelMapper.map(entity, SangriaDTO.class);
		return dto;
	}

	public Sangria convertToEntity(SangriaDTO dto) {
		return modelMapper.map(dto, Sangria.class);
	}

	public List<SangriaDTO> convertToDTO(List<Sangria> list) {
		List<SangriaDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Sangria> convertTo(List<SangriaDTO> list) {
		List<Sangria> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

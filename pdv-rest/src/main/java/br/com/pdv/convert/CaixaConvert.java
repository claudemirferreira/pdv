package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.CaixaDTO;
import br.com.pdv.model.entity.Caixa;

@Component
public class CaixaConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public CaixaDTO convertToDTO(Caixa entity) {
		CaixaDTO dto = modelMapper.map(entity, CaixaDTO.class);
		return dto;
	}

	public Caixa convertToEntity(CaixaDTO dto) {
		return modelMapper.map(dto, Caixa.class);
	}

	public List<CaixaDTO> convertToDTO(List<Caixa> list) {
		List<CaixaDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Caixa> convertTo(List<CaixaDTO> list) {
		List<Caixa> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

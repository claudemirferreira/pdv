package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.VendaDTO;
import br.com.pdv.model.entity.Venda;

@Component
public class VendaConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public VendaDTO convertToDTO(Venda entity) {
		VendaDTO dto = modelMapper.map(entity, VendaDTO.class);
		return dto;
	}

	public Venda convertToEntity(VendaDTO dto) {
		return modelMapper.map(dto, Venda.class);
	}

	public List<VendaDTO> convertToDTO(List<Venda> list) {
		List<VendaDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Venda> convertTo(List<VendaDTO> list) {
		List<Venda> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

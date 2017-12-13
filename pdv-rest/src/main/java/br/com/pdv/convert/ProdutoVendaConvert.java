package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.ProdutoVendaDTO;
import br.com.pdv.model.entity.ProdutoVenda;

@Component
public class ProdutoVendaConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public ProdutoVendaDTO convertToDTO(ProdutoVenda entity) {
		ProdutoVendaDTO dto = modelMapper.map(entity, ProdutoVendaDTO.class);
		return dto;
	}

	public ProdutoVenda convertToEntity(ProdutoVendaDTO dto) {
		return modelMapper.map(dto, ProdutoVenda.class);
	}

	public List<ProdutoVendaDTO> convertToDTO(List<ProdutoVenda> list) {
		List<ProdutoVendaDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<ProdutoVenda> convertTo(List<ProdutoVendaDTO> list) {
		List<ProdutoVenda> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

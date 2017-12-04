package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.model.entity.Produto;

@Component
public class ProdutoConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public ProdutoDTO convertToDTO(Produto entity) {
		ProdutoDTO dto = modelMapper.map(entity, ProdutoDTO.class);
		return dto;
	}

	public Produto convertToEntity(ProdutoDTO dto) {
		return modelMapper.map(dto, Produto.class);
	}

	public List<ProdutoDTO> convertToDTO(List<Produto> list) {
		List<ProdutoDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Produto> convertTo(List<ProdutoDTO> list) {
		List<Produto> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.MovimentacaoProdutoDTO;
import br.com.pdv.model.entity.MovimentacaoProduto;

@Component
public class MovimentacaoProdutoConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public MovimentacaoProdutoDTO convertToDTO(MovimentacaoProduto entity) {
		MovimentacaoProdutoDTO dto = modelMapper.map(entity, MovimentacaoProdutoDTO.class);
		return dto;
	}

	public MovimentacaoProduto convertToEntity(MovimentacaoProdutoDTO dto) {
		return modelMapper.map(dto, MovimentacaoProduto.class);
	}

	public List<MovimentacaoProdutoDTO> convertToDTO(List<MovimentacaoProduto> list) {
		List<MovimentacaoProdutoDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<MovimentacaoProduto> convertTo(List<MovimentacaoProdutoDTO> list) {
		List<MovimentacaoProduto> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

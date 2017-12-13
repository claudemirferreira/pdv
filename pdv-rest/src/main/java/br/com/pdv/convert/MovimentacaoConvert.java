package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.MovimentacaoDTO;
import br.com.pdv.model.entity.Movimentacao;

@Component
public class MovimentacaoConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public MovimentacaoDTO convertToDTO(Movimentacao entity) {
		MovimentacaoDTO dto = modelMapper.map(entity, MovimentacaoDTO.class);
		return dto;
	}

	public Movimentacao convertToEntity(MovimentacaoDTO dto) {
		return modelMapper.map(dto, Movimentacao.class);
	}

	public List<MovimentacaoDTO> convertToDTO(List<Movimentacao> list) {
		List<MovimentacaoDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Movimentacao> convertTo(List<MovimentacaoDTO> list) {
		List<Movimentacao> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

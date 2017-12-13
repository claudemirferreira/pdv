package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.UsuarioDTO;
import br.com.pdv.model.entity.Usuario;

@Component
public class UsuarioConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public UsuarioDTO convertToDTO(Usuario entity) {
		UsuarioDTO dto = modelMapper.map(entity, UsuarioDTO.class);
		return dto;
	}

	public Usuario convertToEntity(UsuarioDTO dto) {
		return modelMapper.map(dto, Usuario.class);
	}

	public List<UsuarioDTO> convertToDTO(List<Usuario> list) {
		List<UsuarioDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Usuario> convertTo(List<UsuarioDTO> list) {
		List<Usuario> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

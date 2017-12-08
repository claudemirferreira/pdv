package br.com.pdv.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pdv.dto.ClienteDTO;
import br.com.pdv.model.entity.Cliente;

@Component
public class ClienteConvert {

	private ModelMapper modelMapper = new ModelMapper();

	public ClienteDTO convertToDTO(Cliente entity) {
		ClienteDTO dto = modelMapper.map(entity, ClienteDTO.class);
		return dto;
	}

	public Cliente convertToEntity(ClienteDTO dto) {
		return modelMapper.map(dto, Cliente.class);
	}

	public List<ClienteDTO> convertToDTO(List<Cliente> list) {
		List<ClienteDTO> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToDTO(l)));
		return result;
	}

	public List<Cliente> convertTo(List<ClienteDTO> list) {
		List<Cliente> result = new ArrayList<>();
		list.stream().forEach(l -> result.add(convertToEntity(l)));
		return result;
	}

}

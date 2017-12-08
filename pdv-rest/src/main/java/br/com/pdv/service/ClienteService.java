package br.com.pdv.service;

import java.util.List;

import br.com.pdv.dto.ClienteDTO;

public interface ClienteService {

	public List<ClienteDTO> findAll();

	public ClienteDTO save(ClienteDTO dto);

	public ClienteDTO update(ClienteDTO dto);

	public ClienteDTO findId(Long id);

	public void delete(Long id);

}
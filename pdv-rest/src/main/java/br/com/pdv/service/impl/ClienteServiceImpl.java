package br.com.pdv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.ClienteConvert;
import br.com.pdv.dto.ClienteDTO;
import br.com.pdv.model.dao.ClienteDAO;
import br.com.pdv.model.entity.Cliente;
import br.com.pdv.service.ClienteService;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDAO dao;

	@Autowired
	private ClienteConvert convert;

	@Override
	public List<ClienteDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public ClienteDTO save(ClienteDTO dto) {
		Cliente entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public ClienteDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public ClienteDTO update(ClienteDTO dto) {
		Cliente entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}
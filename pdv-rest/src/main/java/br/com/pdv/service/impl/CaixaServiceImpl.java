package br.com.pdv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.CaixaConvert;
import br.com.pdv.dto.CaixaDTO;
import br.com.pdv.model.dao.CaixaDAO;
import br.com.pdv.model.entity.Caixa;
import br.com.pdv.service.CaixaService;

@Service
@Transactional
public class CaixaServiceImpl implements CaixaService {

	@Autowired
	private CaixaDAO dao;

	@Autowired
	private CaixaConvert convert;

	@Override
	public List<CaixaDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public CaixaDTO save(CaixaDTO dto) {
		Caixa entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public CaixaDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public CaixaDTO update(CaixaDTO dto) {
		Caixa entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}
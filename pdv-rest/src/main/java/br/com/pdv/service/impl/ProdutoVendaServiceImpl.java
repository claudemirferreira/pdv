package br.com.pdv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.ProdutoVendaConvert;
import br.com.pdv.dto.ProdutoVendaDTO;
import br.com.pdv.model.dao.ProdutoVendaDAO;
import br.com.pdv.model.entity.ProdutoVenda;
import br.com.pdv.service.ProdutoVendaService;

@Service
@Transactional
public class ProdutoVendaServiceImpl implements ProdutoVendaService {

	@Autowired
	private ProdutoVendaDAO dao;

	@Autowired
	private ProdutoVendaConvert convert;


	@Override
	public List<ProdutoVendaDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public ProdutoVendaDTO save(ProdutoVendaDTO dto) {
		ProdutoVenda entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public ProdutoVendaDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public ProdutoVendaDTO update(ProdutoVendaDTO dto) {
		ProdutoVenda entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}
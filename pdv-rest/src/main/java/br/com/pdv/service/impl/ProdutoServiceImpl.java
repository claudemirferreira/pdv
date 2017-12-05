package br.com.pdv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.ProdutoConvert;
import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.model.dao.ProdutoDAO;
import br.com.pdv.model.entity.Produto;
import br.com.pdv.service.ProdutoService;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoDAO dao;

	@Autowired
	private ProdutoConvert convert;

	@Override
	public List<ProdutoDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public ProdutoDTO save(ProdutoDTO dto) {
		Produto entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public ProdutoDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

}
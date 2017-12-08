package br.com.pdv.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pdv.convert.MovimentacaoProdutoConvert;
import br.com.pdv.dto.MovimentacaoProdutoDTO;
import br.com.pdv.model.dao.MovimentacaoProdutoDAO;
import br.com.pdv.model.entity.MovimentacaoProduto;
import br.com.pdv.service.MovimentacaoProdutoService;

@Service
@Transactional
public class MovimentacaoProdutoServiceImpl implements MovimentacaoProdutoService {

	@Autowired
	private MovimentacaoProdutoDAO dao;

	@Autowired
	private MovimentacaoProdutoConvert convert;

	@Override
	public List<MovimentacaoProdutoDTO> findAll() {
		return convert.convertToDTO(dao.findAll());
	}

	@Override
	public MovimentacaoProdutoDTO save(MovimentacaoProdutoDTO dto) {
		MovimentacaoProduto entity = dao.save(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

	@Override
	public MovimentacaoProdutoDTO findId(Long id) {
		return convert.convertToDTO(dao.findId(id));
	}

	@Override
	public void delete(Long id) {
		dao.remove(id);
	}

	@Override
	public MovimentacaoProdutoDTO update(MovimentacaoProdutoDTO dto) {
		MovimentacaoProduto entity = dao.update(convert.convertToEntity(dto));
		return convert.convertToDTO(entity);
	}

}